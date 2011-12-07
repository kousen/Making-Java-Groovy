package mjg

import spock.lang.Specification;

class POJOUnitSpec extends Specification {
    POJO pojo
    
    def setup() {
        pojo = new POJO(one:'1',two:2,three:3.0)
    }
    
    def "initial values set from config"() {
        expect:
        pojo.one == "1"
        pojo.three == 3.0
    }
    
    def "change values via setters"() {
        when:
        pojo.one = "one"
        pojo.three = 333.0
        
        then:
        pojo.one == "one"
        pojo.three == 333.0
    }
    
    def "change two directly"() {
        when: pojo.two = 222
        then: pojo.two == 222
    }
}
