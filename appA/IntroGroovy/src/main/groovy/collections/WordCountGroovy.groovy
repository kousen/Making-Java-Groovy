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