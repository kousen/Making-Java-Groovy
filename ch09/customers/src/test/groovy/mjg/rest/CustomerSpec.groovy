package mjg.rest

import groovy.json.JsonSlurper
import spock.lang.Specification

class CustomerSpec extends Specification {

    def 'transform customer into json string'() {
        given: 'a customer with a first and last name'
        Customer c = new Customer(first:'Johnathan', last:'Archer')

        when: 'convert customer to JSON string'
        String s = c.toJsonString()

        then: 'can convert string back to customer'
        s == '{"id":null,"first":"Johnathan","last":"Archer"}'
        def json = new JsonSlurper().parseText(s)
        Customer c1 = new Customer(json)
        c1 == c
    }

	def 'transform customer into json'() {
        given: 'a customer with a first and last name'
        Customer c = new Customer(first:'Johnathan', last:'Archer')

        expect: 'convert customer to JSON'
        c.toJson() == [id:null, first:'Johnathan', last:'Archer']
    }
}
