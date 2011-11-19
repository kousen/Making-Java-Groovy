package mjg

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import spock.lang.Specification;

@ContextConfiguration("/applicationContext.xml")
class POJOIntegrationSpec extends Specification {
    @Autowired
    POJO pojo
    
    def "initial values set from config"() {
        expect:
        // pojo.one == "1"
        pojo.three == 3.0
    }
    
    def "change values via setters"() {
        when:
        // pojo.one = "one"
        pojo.three = 333.0
        
        then:
        // pojo.one == "one"
        pojo.three == 333.0
    }
    
//    def "change two directly"() {
//        when: pojo.two = 222
//        then: pojo.two == 222
//    }
}
