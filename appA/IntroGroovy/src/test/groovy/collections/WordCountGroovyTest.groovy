package collections

class WordCountGroovyTest extends GroovyTestCase {
	def wcg = new WordCountGroovy()
	
	void testCountWords() {
		wcg.countWords()
		def count = wcg.getWordCount();
		assert 2, count.get("an")
		assert 3, count.get("with")
		assert 8, count.get("and")
		
		println wcg.mostFrequent
	}
}