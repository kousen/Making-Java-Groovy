package mjg.rest

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation
import java.lang.reflect.Type

import javax.ws.rs.Consumes
import javax.ws.rs.Produces
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.MultivaluedMap
import javax.ws.rs.ext.MessageBodyReader
import javax.ws.rs.ext.MessageBodyWriter
import javax.ws.rs.ext.Provider

@Provider
@Produces('application/json')
@Consumes('application/json')
class PersonProvider implements MessageBodyWriter<Person>, MessageBodyReader<Person> {

    @Override
    boolean isWriteable(Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        type == Person && mediaType == MediaType.APPLICATION_JSON_TYPE
    }

    @Override
    long getSize(Person t, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    void writeTo(Person t, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException,
    WebApplicationException {
        def builder = new JsonBuilder()
        builder {
            id t.id
            first t.first
            last t.last
            links {
                if (t.prev) {
                    prev t.prev.toString()
                } 
                self t.self.toString()
                if (t.next) {
                    next t.next.toString()
                } 
            }
        }
        entityStream.write(builder.toString().bytes)
    }
    
    @Override
    public boolean isReadable(Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        type == Person && mediaType == MediaType.APPLICATION_JSON_TYPE
    }
            
    @Override
    public Person readFrom(Class<Person> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {

        def json = new JsonSlurper().parseText(entityStream.text)
        Person p = new Person(id:json.id, first:json.first, last:json.last)
        if (json.links) {
            p.prev = Link.valueOf(json.links.prev)
            p.self = Link.valueOf(json.links.self)
            p.next = Link.valueOf(json.links.next)
        }
        return p
    }
}
