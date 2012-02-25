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