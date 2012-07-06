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
package conditionals

if (true) assert true

if (1)
	assert true
else
	assert false

def result = 5 > 3 ? 'x' : 'y'
assert result == 'x'

// name supplied as a parameter, or not

// result = name ? name : 'Elvis'
// like nvl(varname,literal) in SQL

def greet(name) { "${name ?: 'Elvis'} has left the building" }
assert greet() == 'Elvis has left the building'
assert greet(null) == 'Elvis has left the building'
assert greet('Priscilla') == 'Priscilla has left the building'

def hello(name = 'World') { "Hello, $name!" }
assert hello() == 'Hello, World!'
assert hello(null) == 'Hello, null!'
assert hello('Dolly') == 'Hello, Dolly!'

// 'reused' from Groovy In Action -- buy it!
switch (10) {
	case 0: 			assert false; break
	case 0..9: 			assert false; break
	case [8,9,11]: 		assert false; break
	case Float: 		assert false; break
	case { it%3 == 0 }: assert false; break
	case ~/../: 		assert true; break
	default: 			assert false
}

def val
def a, b, c
// long form (Java like)
if (a != null) {
	if (a.b != null) {
		val = a.b.c
	} else {
		val = null
	}
} else {
	val = null
}

// easier way (Groovy)
val = a?.b?.c
