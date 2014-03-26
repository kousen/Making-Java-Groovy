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
package builders

import groovy.xml.MarkupBuilder;

def writer = new StringWriter()
def builder = new MarkupBuilder(writer)
def department = builder.department {
	deptName "Construction"
	employee(id:1) {
		name "Fred"
	}
	employee(id:2) {
		name "Barney"
	}
}
println writer

builder = new MarkupBuilder()
builder.numbers {
	(0..5).each {
		num it
	}
}