package mjg.spring

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import spock.lang.Specification;

@ContextConfiguration("file:resources/applicationContext.xml")
class JavaEvaluatorSpec extends Specification {
    @Autowired
    JavaEvaluator e
    
    def "evaluator injected properly"() {
        expect: e
    }
    
    def "evaluator returns true"() {
        expect: e.approve null
    }
}
