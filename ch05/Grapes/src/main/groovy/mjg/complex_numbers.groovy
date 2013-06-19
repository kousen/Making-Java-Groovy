/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
package mjg

import static org.apache.commons.math3.complex.Complex.*
import static java.lang.Math.*

import org.apache.commons.math3.complex.*

@Grab('org.apache.commons:commons-math3:3.0')
Complex first = new Complex(1.0, 3.0);
Complex second = new Complex(2.0, 5.0);

assert first.multiply(second) == first * second
println first * second
println "$first == ($first.real, $first.imaginary)"

ComplexFormat fmt = new ComplexFormat()
println fmt.format(first)
println fmt.format(second)

Complex.metaClass.plus = { Complex c -> delegate.add c }
Complex.metaClass.minus = { Complex c -> delegate.subtract c }
Complex.metaClass.div = { Complex c -> delegate.divide c }
Complex.metaClass.power = { Complex c -> delegate.pow c }
Complex.metaClass.negative = { delegate.negate() }

assert new Complex(3.0, 8.0) == first + second
assert new Complex(1.0, 2.0) == second - first
assert new Complex(0.5862068965517241, 0.03448275862068969) == first / second
assert new Complex(-0.007563724861696302, 0.01786136835085382) == first ** second
assert new Complex(-1.0, -3.0) == -first

Double.metaClass.power = { Complex c -> (new Complex(delegate,0)).pow(c) }

Complex result = E ** (I * PI)
assert result.real == -1 
assert result.imaginary < 1.0e-15 