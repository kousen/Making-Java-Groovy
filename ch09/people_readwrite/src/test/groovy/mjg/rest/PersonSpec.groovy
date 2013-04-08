package mjg.rest

import groovy.json.JsonSlurper
import spock.lang.Specification

class PersonSpec extends Specification {
    
    def 'add to set to verify equals and hashcode'() {
        given: 'two equivalent people and one different one'
        Person p1 = new Person(first:'Johnathan', last:'Archer')
        Person p2 = new Person(first:'Johnathan', last:'Archer')
        Person p3 = new Person(first:'Peter Quincy', last:'Taggart')

        when: 'add them all to a set'
        Set people = [p1, p2, p3]
        
        then: 'set only contains two of them'
        people.size() == 2
        p1 == p2
        p1 != p3
    }

    def 'transform person into json string'() {
        given: 'a person with a first and last name'
        Person p = new Person(first:'Johnathan', last:'Archer')

        when: 'convert person to JSON string'
        String s = p.toJsonString()

        then: 'can convert string back to person'
        s == '{"id":null,"first":"Johnathan","last":"Archer"}'
        def json = new JsonSlurper().parseText(s)
        Person p1 = new Person(json)
        p1 == p
    }

	def 'transform person into json'() {
        given: 'a customer with a first and last name'
        Person p = new Person(first:'Johnathan', last:'Archer')

        expect: 'convert person to JSON'
        p.toJson() == [id:null, first:'Johnathan', last:'Archer']
    }
    
    def 'transform person into XML'() {
        given: 'a person with a first and last name'
        Person p = new Person(id:99, first:'Johnathan', last:'Archer')
        
        expect: 'convert person to XML'
        def xml = new XmlSlurper().parseText(p.toXML())
        xml.@id.toLong() == p.id
        xml.first == p.first
        xml.last == p.last
    }
}
