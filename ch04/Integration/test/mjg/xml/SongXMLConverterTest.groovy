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
package mjg.xml;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class SongXMLConverterTest {
    SongXMLConverter s2x = new SongXMLConverter()

    @Test
    void testSong2XmlAndBack() {
        def s1 = new Song(id:1,title:'title',artist:'artist',year:'year')
        def s2 = s2x.xml2song(s2x.song2xml(s1))

        assert s1.id == s2.id
        assert s1.title == s2.title
        assert s1.artist == s2.artist
        assert s1.year == s2.year
    }

    @Test
    void testSonglist2xml() {
        def songs = []
        songs << new Song(id:1,title:'title1',artist:'artist1',year:'year1')
        songs << new Song(id:2,title:'title2',artist:'artist2',year:'year2')
        def xml = '<songs>'
        xml += s2x.song2xml(songs[0])
        xml += s2x.song2xml(songs[1])
        xml += '</songs>'
        
        def root = new XmlSlurper().parseText(s2x.songlist2xml(songs))
        assert 2 == root.song.size()
        
        def ids = root.song.@id*.text()
        assert ids.contains('1')
        assert ids.contains('2')
        assert root.song.title*.text().contains('title1')
        assert root.song.year*.text().contains('year2')
    }

    @Test
    void testXml2SongAndBack() {
        def sw = new StringWriter()
        def builder = new groovy.xml.MarkupBuilder(sw)
        builder.song(id:1) {
            title 'title'
            artist 'artist'
            year 'year'
        }
        def xml = sw.toString()
        assert xml == s2x.song2xml(s2x.xml2song(xml))
    }

    @Test
    void testXml2songlist() {
        def songs = []
        songs << new Song(id:1,title:'title1',artist:'artist1',year:'year1')
        songs << new Song(id:2,title:'title2',artist:'artist2',year:'year2')
        
        def xml = '<songs>'
        xml += s2x.song2xml(songs[0])
        xml += s2x.song2xml(songs[1])
        xml += '</songs>'
        
        def reply = s2x.xml2songlist(xml)
        assert songs*.@id.contains(reply[0].@id)
        assert songs*.title.contains(reply[1].title)
        assert songs*.artist.contains(reply[0].artist)
        assert songs*.year.contains(reply[1].year)
    }
}
