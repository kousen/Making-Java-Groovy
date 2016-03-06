package mjg.rest

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient

import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class PersonResourceSpec extends Specification {
    @Shared HttpServer server
    @Shared RESTClient client =
            new RESTClient('http://localhost:1234/',
                    ContentType.JSON)

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
		with(response) {
			status == 200
			contentType == 'application/json'
			data.size() == 5
		}
		
//        response.status == 200
//        response.contentType == 'application/json'
//        response.data.size() == 5
    }

    @Unroll
    def "people/#id gives #name"() {
        expect:
        def response = client.get(path: "people/$id")
        name == "$response.data.first $response.data.last"
        response.status == 200

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
        with(response) {
            data.first == 'Peter Quincy'
            data.last == 'Taggart'
            status == 201
            contentType == 'application/json'
            headers.Location == "http://localhost:1234/people/${response.data.id}"
        }

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
