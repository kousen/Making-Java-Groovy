package mjg

import spock.lang.Specification

class MyFirstSpec extends Specification {
    def "max of two numbers"() {
        expect:
        Math.max(1, 2) == 2
    }

    def 'max method on a list works'() {
        expect:
        [3, 1, 4, 1, 5, 9].max() == 9
        [3, -1, 4, -5].min() == -5
    }
}
