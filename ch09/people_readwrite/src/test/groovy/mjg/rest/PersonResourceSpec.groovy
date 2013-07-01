package mjg.rest

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.Link
import javax.ws.rs.core.Response

import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class PersonResourceSpec extends Specification {
    @Shared static HttpServer server
    RESTClient client = new RESTClient('http://localhost:1234/', ContentType.JSON)
    
    void setupSpec() {
        server = GrizzlyHttpServerFactory.createHttpServer(
            'http://localhost:1234/'.toURI(), new MyApplication())
    }

    def 'server is running'() {
        expect: server.started
    }
	
    def 'get request returns all people'() {
        when:
        def response = client.get(path: 'people')

        then:
		response.status == 200
        response.contentType == 'application/json'
        response.data.size() == 5
    }

    def 'structural and transitional links for kirk are correct'() {
        Client cl = ClientBuilder.newClient()
        WebTarget target = cl.target('http://localhost:1234/people/3')
        
        when:
        def response = client.get(path: 'people/3')
        def resp = target.request().get(Response.class)
        
        then:
        'James Kirk' == "$response.data.first $response.data.last"
        Link.valueOf(response.data.links.prev).uri == 'http://localhost:1234/people/2'.toURI()
        Link.valueOf(response.data.links.self).uri == 'http://localhost:1234/people/3'.toURI()
        Link.valueOf(response.data.links.next).uri == 'http://localhost:1234/people/4'.toURI()
        resp.getLink('prev').uri == 'http://localhost:1234/people/2'.toURI()
        resp.getLink('self').uri == 'http://localhost:1234/people/3'.toURI()
        resp.getLink('next').uri == 'http://localhost:1234/people/4'.toURI()
    }
    
    @Unroll
    def "people/#id gives #name"() {
        expect:
        def response = client.get(path: "people/$id")
        name == "$response.data.first $response.data.last"
        response.status == 200
//        println response.data.prev
//        println response.data.self
//        println response.data.next

        where:
        id |       name 
        1  | 'Jean-Luc Picard'
        2  | 'Johnathan Archer'	
        3  | 'James Kirk'
        4  | 'Benjamin Sisko'
        5  | 'Kathryn Janeway'	
    }

    def 'people/lastname/{like} searches for last names that include given string'() {
        when:
        def response = client.get(path: "people/lastname/a")

        then:
        response.data.size() == 3
        response.data*.last ==~ /.*[aA].*/ 
    }

    def 'insert and delete a person'() {
        given: 'A JSON object with first and last names'
        def json = [first: 'Peter Quincy', last: 'Taggart']

        when: 'post the JSON object'
        def response = client.post(path: 'people', 
            contentType: ContentType.JSON, body: json)

        then: 'number of stored objects goes up by one'
        getAll().size() == old(getAll().size()) + 1
        response.data.first == 'Peter Quincy'
        response.data.last == 'Taggart'
        response.status == 201
        response.contentType == 'application/json'
        response.headers.Location == "http://localhost:1234/people/${response.data.id}"
	
        when: 'delete the new JSON object'
        client.delete(path: response.headers.Location)

        then: 'number of stored objects goes down by one'
        getAll().size() == old(getAll().size()) - 1
    }

    def 'can update an existing person'() {
        given:
        def kirk = client.get(path: 'people/3')
        def json = [id: 3, first:'James T.', last: 'Kirk']

        when:
        def response = client.put(path: "people/${kirk.data.id}", 
            contentType: ContentType.JSON, body: json)

        then:
        "$response.data.first $response.data.last" == 'James T. Kirk'
    }

    private List getAll() {
        client.get(path: 'people').data
    }

    void cleanupSpec() {
        server?.stop()
    }
}
