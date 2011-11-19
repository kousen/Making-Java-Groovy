package collections

class WordCountGroovy {
	def wordCount = [:]
	
	void countWords() {
		def file = new File('src/main/groovy/collections/passage.txt')
		file.eachLine { line ->
			List words = line.tokenize()
			words.each { word ->
				wordCount[word] = wordCount.get(word,0) + 1
			}
		}
	}
	
	Map<String,Integer> getMostFrequent() {
		def sorted = [:]
		def sortedKeys = wordCount.keySet().sort { wordCount[it] }
		sortedKeys[-1..-5].each { word ->
			sorted[word] = wordCount[word]
		}
		return sorted
	}
}