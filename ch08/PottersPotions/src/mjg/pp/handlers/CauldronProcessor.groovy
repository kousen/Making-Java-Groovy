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
