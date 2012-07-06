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
package mjg

import groovy.xml.MarkupBuilder 

class Song2XML {
	String song2xml(Song s) {
		StringWriter sw = new StringWriter()
		def builder = new MarkupBuilder(sw)
		builder.song(id:s.id) {
			title s.title 
			artist s.artist
			year s.year
		}
		return sw.toString()
	}
	
	String songlist2xml(songs) {
		def xml = '<songs>'
		songs.each { s ->
			xml += song2xml(s)
		}
		xml += '</songs>'
		return xml
	}
	
	Song xml2song(String xml) {
		def root = new XmlSlurper().parseText(xml)
		Song s = new Song(id:root.@id,title:root.title,
			artist:root.artist,year:root.year)
		return s
	}
	
	def xml2songlist(xml) {
		def songs = []
		def root = new XmlSlurper().parseText(xml)
		root.song.each { s ->
			songs << new Song(id:s.@id,title:s.title,
				artist:s.artist,year:s.year)
		}
		return songs
	}
}
