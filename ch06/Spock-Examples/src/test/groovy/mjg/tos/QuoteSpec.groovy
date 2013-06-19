package mjg.tos

import spock.lang.Specification;

class QuoteSpec extends Specification {
	String quote = """I am endeavoring, ma'am, to construct a 
		mnemonic memory circuit using stone knives and bear skins."""
		
	List<String> strings
	
	def setup() {
		strings = quote.tokenize(" ,.")
	}
	
	def "should be 16 words"() {
		expect: strings.size() == 16
	}
	
	def "add a word increases total by 1"() {
		when:
		strings << '(eyebrow)'
		
		then:
		strings.size() == old(strings.size()) + 1
	}
}
