package mjg.rest

import groovy.json.JsonBuilder
import groovy.transform.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
@EqualsAndHashCode
class Customer {
	Long id
	String first
	String last
	
	String toString() {
		"$first $last"
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
