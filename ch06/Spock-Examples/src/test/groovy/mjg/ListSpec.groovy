package mjg

import spock.lang.Ignore;
import spock.lang.Specification;

class ListSpec extends Specification {
    List strings
    
    def setup() {
        strings = ['this','is','a','list','of','strings']
    }

    def "there are six strings"() {
        expect: strings.size() == 6
    }
    
    def "add a string"() {
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
    
    def 'no exception if I stay inside list'() {
        when:
        (0..5).each { strings[it] }
        strings[6]
        
        then:
        notThrown()
    }
    
    def "list is still the same"() {
        when:
        def newList = strings - 'this' + 'stuff'
        
        then:
        newList.size() == 6
    }
}
