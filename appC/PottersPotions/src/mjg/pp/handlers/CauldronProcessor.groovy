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
package mjg.pp.handlers


import groovy.xml.dom.DOMCategory;

import org.w3c.dom.Element;

class CauldronProcessor {
	Element body
	
	def printInfo() {
		use (DOMCategory) {
			println "There are ${body.'**'.size()} nodes"
			println body.list()
		}
	}
	
	boolean detectDarkArts() {
		use (DOMCategory) {  // needed for '**' property
			return body.'**'.any { it =~ /.*unicorn.*/ }
		} 
	}
	
	def addDisclaimer() {
		use (DOMCategory) {  // needed for '**' and replaceNode
			def e = body.'**'.find { it.name() == 'effect' }
			e.replaceNode {
				effect "Possible dark arts detected. No warranty expressed or implied"
			}
		}
	}
}
