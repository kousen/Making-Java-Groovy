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
