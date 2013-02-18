package mjg.rest

import groovy.json.JsonSlurper
import spock.lang.Specification

class PersonSpec extends Specification {

    def 'transform customer into json string'() {
        given: 'a customer with a first and last name'
        Person c = new Person(first:'Johnathan', last:'Archer')

        when: 'convert customer to JSON string'
        String s = c.toJsonString()

        then: 'can convert string back to customer'
        s == '{"id":null,"first":"Johnathan","last":"Archer"}'
        def json = new JsonSlurper().parseText(s)
        Person c1 = new Person(json)
        c1 == c
    }

	def 'transform customer into json'() {
        given: 'a customer with a first and last name'
        Person c = new Person(first:'Johnathan', last:'Archer')

        expect: 'convert customer to JSON'
        c.toJson() == [id:null, first:'Johnathan', last:'Archer']
    }
    
    def 'transform customer into XML'() {
        given: 'a customer with a first and last name'
        Person c = new Person(id:99, first:'Johnathan', last:'Archer')
        
        expect: 'convert customer to XML'
        def xml = new XmlSlurper().parseText(c.toXML())
        xml.@id.toLong() == c.id
        xml.first == c.first
        xml.last == c.last
    }
}
