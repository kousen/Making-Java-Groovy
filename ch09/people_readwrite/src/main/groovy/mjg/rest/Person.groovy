package mjg.rest

import groovy.json.JsonBuilder
import groovy.transform.EqualsAndHashCode
import groovy.xml.MarkupBuilder

import javax.ws.rs.core.Link
import javax.ws.rs.core.Link.JaxbAdapter
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

@EqualsAndHashCode
@XmlRootElement
class Person {
    Long id
    String first
    String last
    
    Link prev
    Link self
    Link next

    String toString() {
        "$first $last"
    }
    
    String toXML() {
        StringWriter writer = new StringWriter()
        def builder = new MarkupBuilder(writer)
        builder.person(id:id) {
            first first
            last last
        }
        writer.toString()
    }

    Map toJson() {
        def builder = new JsonBuilder()
        def root = builder {
            id id
            first first
            last last
        }
    }

    String toJsonString() {
        def builder = new JsonBuilder()
        def root = builder {
            id id
            first first
            last last
        }
        builder.toString()
    }
}
