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
import mjg.*

def dao = SongDAO.instance

switch (request.method) {
	case 'GET' :
		if (params?.id) {
			def s = dao.getSong(params.id)
			html.song(id:s.id) {
				title s.title
				artist s.artist
				year s.year
			}
		} else {
			def songs = dao.getAllSongs()
			html.songs {
				songs.each { s ->
					song(id:s.id) {
						title s.title
						artist s.artist
						year s.year
					}
				}
			}
		}
		break
	case 'POST' :
		def data = new XmlSlurper().parse(request.reader)
		def s = new Song(id:data.@id,title:data.title,
					artist:data.artist,year:data.year)
		def exists = dao.exists(s.id)
		
		if (!exists) {
			dao.addSong s
			response.addHeader 'Location',"http://localhost:8163/GroovySongs/SongService.groovy?id=${s.id}"
			out.print "${s.title} added with id ${s.id}"
		} else {
			out.print "${s.title} already exists"
		}
		break
	case 'DELETE' :
		dao.deleteSong params.id
		out.print "${params.id} deleted"
		break
	default:
		print 'Only GET, POST, and DELETE supported'
}