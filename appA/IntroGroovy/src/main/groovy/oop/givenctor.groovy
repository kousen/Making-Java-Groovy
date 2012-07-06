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
package oop

class Employee {
	int id
	String name
	
	Employee(id,name) {
		this.id = id
		this.name = name
	}
	
	String toString() {
		"($id,$name)"
	}
}

// Use constructor directly
def fred = new Employee(1,'Fred Flintstone')

// Coerce array using 'as'
def barney = [2, 'Barney Rubble'] as Employee

// Coercion in assignment
Employee wilma = [3, 'Wilma Flintstone']

// Spread-dot operator
def args = [4,'Betty Rubble']
def betty = new Employee(*args)

assert fred.toString() == '(1,Fred Flintstone)'
assert barney.toString() == '(2,Barney Rubble)'
assert wilma.toString() == '(3,Wilma Flintstone)'
assert betty.toString() == '(4,Betty Rubble)'