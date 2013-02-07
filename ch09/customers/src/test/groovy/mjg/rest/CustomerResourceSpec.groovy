package mjg.rest

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient

import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class CustomerResourceSpec extends Specification {
	@Shared static HttpServer server
	RESTClient client = new RESTClient('http://localhost:1234/', ContentType.JSON)
	
	void setupSpec() {
		server = GrizzlyHttpServerFactory.createHttpServer(
			URI.create('http://localhost:1234/'), new MyApplication())
	}
	
	def 'server is running'() {
		expect: server.started
	}
	
	def 'get request returns all customers'() {
		when:
		def response = client.get(path: 'customers')
		
		then:
		response.status == 200
		response.contentType == 'application/json'
		response.data.size() == 5
	}
	
	@Unroll
	def "customer/#id gives #name"() {
		expect:
		def response = client.get(path: "customers/$id")
		name == "$response.data.first $response.data.last"
		
		where:
		id |       name 
		1  | 'Jean-Luc Picard'
		2  | 'Johnathan Archer'	
		3  | 'James Kirk'
		4  | 'Benjamin Sisko'
		5  | 'Kathryn Janeway'	
	}
	
	def "customer/name searches for last names that include given string"() {
		when:
		def response = client.get(path: "customers/search/a")
		
		then:
		response.data.size() == 3
		response.data*.last ==~ /.*[aA].*/ 
	}
	
	def 'insert and delete a customer'() {
		given: 'A JSON object with first and last names'
		String json = '{"first": "Christopher", "last": "Pike"}'
		
		when: 'post the JSON object'
		def response = client.post(path: 'customers', 
			contentType: ContentType.JSON, body: json)
		
		then: 'number of stored objects goes up by one'
		getAll().size() == old(getAll().size()) + 1
		response.data.first == 'Christopher'
		response.data.last == 'Pike'
			
		when: 'delete the new JSON object'
		client.delete(path: "customers/${response.data.id}")
		
		then: 'number of stored objects goes down by one'
		getAll().size() == old(getAll().size()) - 1
	}
	
	def 'can update an existing customer'() {
		given:
		def kirk = client.get(path: 'customers/3')
		def json = '{"id":3, "first":"James T.", "last":"Kirk"}'
		
		when:
		def response = client.put(path: 'customers/3', 
			contentType: ContentType.JSON, body: json)
		
		then:
		"$response.data.first $response.data.last" == 'James T. Kirk'
	}
	
	private List getAll() {
		client.get(path: 'customers').data
	}
	
	void cleanupSpec() {
		server?.stop()
	}
}
