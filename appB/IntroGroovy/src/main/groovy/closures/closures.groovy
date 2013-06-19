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
package closures

// supplying closure to each
def total = 0
(1..10).each { num -> total += num }
assert (1..10).sum() == total
total = 0
(1..10).each { total += it }
assert (1..10).sum() == total

// calling a closure
def echo = { it }
assert "Hello" == echo('Hello')
assert "Hello" == echo.call('Hello')

// currying closures
def sumN = { n,list -> list[0..n-1].sum() }
assert sumN(1, [1,2,3]) == 1
assert sumN(2, [1,2,3]) == 3
assert sumN(3, [1,2,3]) == 6

def sum3 = sumN.curry(3)
assert sum3([1,2,3,4,5]) == 6