package mjg

import spock.lang.Ignore;
import spock.lang.Specification;

class ListSpec extends Specification {
    List strings
    
    def setup() {
        strings = ['light', 'light', 'light', 'light']
    }

    def "there are four lights"() {
        expect: strings.size() == 4
    }
    
    def "add two strings string"() {
        when:
        strings << "plus"
        strings << "two"
        
        then:
        strings.size() == old(strings.size()) + 2
    }
    
    def "NPE if I don't instantiate the list"() {
        when:
        List empty
        empty << 'data'
        
        then:
        def e = thrown(NullPointerException)
        //NullPointerException e = thrown()
        println e.message
    }
    
    def 'no exception using the getAt method'() {
        when:
        (0..5).each { strings[it] }
        strings[6]
        
        then:
        notThrown()
    }
    
    def "There Are Four Lights!"() {
        expect:
        strings.findAll { it ==~ /light/ }.size() == 4
    }
}
