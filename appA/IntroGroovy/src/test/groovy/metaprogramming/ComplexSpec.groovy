package metaprogramming

import static org.apache.commons.math3.complex.Complex.*
import static java.lang.Math.*

import org.apache.commons.math3.complex.*
import spock.lang.Specification

class ComplexSpec extends Specification {
    
    def setupSpec() {
        Complex.metaClass.plus = { Complex c -> delegate.add c }
        Complex.metaClass.minus = { Complex c -> delegate.subtract c }
        Complex.metaClass.div = { Complex c -> delegate.divide c }
        Complex.metaClass.power = { Complex c -> delegate.pow c }
        Complex.metaClass.negative = { delegate.negate() }
        Double.metaClass.power = { Complex c -> (new Complex(delegate,0)).pow(c) }
    }

    def "plus method aliased to add"() {
        given:
        Complex first = new Complex(1.0, 3.0);
        Complex second = new Complex(2.0, 5.0);
    
        expect:
        new Complex(3.0, 8.0) == first + second
    }
    
    def "minus method aliased to subtract"() {
        given:
        Complex first = new Complex(1.0, 3.0);
        Complex second = new Complex(2.0, 5.0);
    
        expect:
        new Complex(1.0, 2.0) == second - first
    }
    
    def "negative method negates complex"() {
        given:
        Complex minus1 = -ONE
        
        expect:
        minus1.real == -1
        minus1.imaginary.abs() == 0
    }
    
    def "Euler's formula still works"() {
        when:
        Complex result = E ** (I * PI)
        
        then:
        result.real == -1
        result.imaginary.abs() < 1e-15
    }
}
