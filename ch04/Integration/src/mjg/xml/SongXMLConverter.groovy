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
package mjg.xml

import groovy.util.XmlSlurper;
import groovy.xml.MarkupBuilder;

import java.io.StringWriter;
import java.util.List

class SongXMLConverter {
    String song2xml(Song s) {
        StringWriter sw = new StringWriter()
        MarkupBuilder builder = new MarkupBuilder(sw)
        builder.song(id:s.id) {
            title s.title
            artist s.artist
            year s.year
        }
        return sw.toString()
    }
    
    Song xml2song(String xml) {
        def root = new XmlSlurper().parseText(xml)
        return new Song(id:root.@id.toInteger(),
            title:root.title, artist:root.artist, year:root.year)
    }
    
    String songlist2xml(songs) {
        StringWriter sw = new StringWriter()
        MarkupBuilder builder = new MarkupBuilder(sw)
        builder.songs {
            songs.each { s ->
                 song(id:s.@id) {
                     title s.title
                     artist s.artist
                     year s.year
                 }   
            }
        }
        return sw.toString()
    }
    
    List<Song> xml2songlist(String xml) {
        def result = []
        def root = new XmlSlurper().parseText(xml)
        root.song.each { s ->
            result << new Song(id:s.@id.toInteger(),title:s.title,
                artist:s.artist,year:s.year)
        }
        return result
    }
}
