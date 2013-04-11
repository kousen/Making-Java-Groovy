package mjg.rest;

import static org.junit.Assert.*

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.Response

import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

class PersonResourceTest {
    static HttpServer server

    @BeforeClass
    static void initialize() throws Exception {
        server = GrizzlyHttpServerFactory.createHttpServer(
                'http://localhost:1234/'.toURI(), new MyApplication())
    }

    @Test
    void testNextAndPreviousHeaders() {
        Client cl = ClientBuilder.newClient()
        int id = 1
        WebTarget target = cl.target("http://localhost:1234/people/$id")
        def resp = target.request().get(Response.class)
        def next = resp.getLink('next').uri
        assert next.toString()[-1] == (++id).toString()
        println 'following next links...'
        while (next) {
            println "Accessing $next"
            target = cl.target(next)
            resp = target.request().get(Response.class)
            next = resp.getLink('next')?.uri
            if (next)
                assert next.toString()[-1] == (++id).toString()
        }
        println 'following prev links...'
        def prev = resp.getLink('prev').uri
        assert prev.toString()[-1] == (--id).toString()
        while (prev) {
            println "Accessing $prev"
            target = cl.target(prev)
            resp = target.request().get(Response.class)
            prev = resp.getLink('prev')?.uri
            if (prev)
                assert prev.toString()[-1] == (--id).toString()
        }
        cl.close()
    }

    @AfterClass
    static void shutdown() {
        server?.stop()
    }
}
