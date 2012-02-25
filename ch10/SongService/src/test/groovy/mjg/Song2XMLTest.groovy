package mjg

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class Song2XMLTest {
	Song2XML s2x

	@Before
	public void setUp() throws Exception {
		s2x = new Song2XML()
	}

	@Test
	public void testSong2XmlAndBack() {
		def s1 = new Song(id:'1',title:'title',artist:'artist',year:'year')
		def s2 = s2x.xml2song(s2x.song2xml(s1))
		assertEquals s1.id, s2.id
		assertEquals s1.title, s2.title
		assertEquals s1.artist, s2.artist
		assertEquals s1.year, s2.year
	}

	@Test
	public void testSonglist2xml() {
		def songs = []
		songs << new Song(id:'1',title:'title1',artist:'artist1',year:'year1')
		songs << new Song(id:'2',title:'title2',artist:'artist2',year:'year2')
		def xml = '<songs>'
		xml += s2x.song2xml(songs[0])
		xml += s2x.song2xml(songs[1])
		xml += '</songs>'
		def root = new XmlSlurper().parseText(s2x.songlist2xml(songs))
		assertEquals 2, root.song.size()
		def ids = root.song.@id*.text()
		assertTrue ids.contains('1')
		assertTrue ids.contains('2')
		assertTrue root.song.title*.text().contains('title1')
		assertTrue root.song.year*.text().contains('year2')
	}

	@Test
	public void testXml2SongAndBack() {
		def sw = new StringWriter()
		def builder = new groovy.xml.MarkupBuilder(sw)
		builder.song(id:'1') {
			title 'title'
			artist 'artist'
			year 'year'
		}
		def xml = sw.toString()
		assertEquals xml, s2x.song2xml(s2x.xml2song(xml))
	}

	@Test
	public void testXml2songlist() {
		def songs = []
		songs << new Song(id:'1',title:'title1',artist:'artist1',year:'year1')
		songs << new Song(id:'2',title:'title2',artist:'artist2',year:'year2')
		def xml = '<songs>'
		xml += s2x.song2xml(songs[0])
		xml += s2x.song2xml(songs[1])
		xml += '</songs>'
		def reply = s2x.xml2songlist(xml)
		assertTrue songs*.@id.contains(reply[0].@id)
		assertTrue songs*.title.contains(reply[1].title)
		assertTrue songs*.artist.contains(reply[0].artist)
		assertTrue songs*.year.contains(reply[1].year)
	}
}
