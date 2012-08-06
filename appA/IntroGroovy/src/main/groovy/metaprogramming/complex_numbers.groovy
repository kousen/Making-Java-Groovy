package metaprogramming

import static org.apache.commons.math3.complex.Complex.*
import static java.lang.Math.*

import org.apache.commons.math3.complex.*

Complex lhs = new Complex(1.0, 3.0);
Complex rhs = new Complex(2.0, 5.0);

assert lhs.multiply(rhs) == lhs * rhs
println lhs * rhs
println "$lhs == ($lhs.real, $lhs.imaginary)"

ComplexFormat fmt = new ComplexFormat()
println fmt.format(lhs)
println fmt.format(rhs)

Complex.metaClass.plus = { Complex c -> delegate.add c }
Complex.metaClass.minus = { Complex c -> delegate.subtract c }
Complex.metaClass.div = { Complex c -> delegate.divide c }
Complex.metaClass.power = { Complex c -> delegate.pow c }
Complex.metaClass.negative = { delegate.negate() }
assert new Complex(3.0, 8.0) == lhs + rhs
assert new Complex(1.0, 2.0) == rhs - lhs
assert new Complex(0.5862068965517241, 0.03448275862068969) == lhs / rhs
assert new Complex(-0.007563724861696302, 0.01786136835085382) == lhs ** rhs
assert new Complex(-1.0, -3.0) == -lhs

Double.metaClass.power = { Complex c -> (new Complex(delegate,0)).pow(c) }

println fmt.format( ( I * PI ).exp() )
println fmt.format( new Complex(E, 0) ** (I * PI) )
println fmt.format( E ** (I * PI) )
assert (E ** (I * PI)).real == -1 
assert (E ** (I * PI)).imaginary < 1.0e-15 