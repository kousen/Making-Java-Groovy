package ast.singleton

import spock.lang.Specification;

class SingletonPointSpec extends Specification {
    def "can't instantiate"() {
        when: point = new SingletonPoint(x:3,y:4)
        then: thrown(RuntimeException)
    }
    
    def "instance is not null"() {
        expect: SingletonPoint.instance
    }
    
    def "can change values"() {
        when:
        SingletonPoint.instance.x = 3
        SingletonPoint.instance.y = 4
        
        then:
        SingletonPoint.instance.x == 3
        SingletonPoint.instance.y == 4
    }
    
}
