package mjg;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

import mjg.Song;
import mjg.Song2XML;

import org.springframework.web.client.RestTemplate;

public class SongClient {
	private RestTemplate template;
	private Song2XML converter = new Song2XML();
	private Logger log = Logger.getLogger("SongClient");
	
	public void setTemplate(RestTemplate template) {
		this.template = template;
	}
	
	@SuppressWarnings("unchecked")
	public List<Song> getSongs() {
		String url = "http://localhost:8163/SongService/SongService.groovy";
		String results = template.getForObject(url, String.class);
		log.info(results);
		return (List<Song>) converter.xml2songlist(results);
	}
	
	public Song getSongById(String id) {
		String url = "http://localhost:8163/SongService/SongService.groovy?id={id}";
		String results = template.getForObject(url, String.class, id);
		log.info(results);
		return converter.xml2song(results);
	}

	public void addSong(String id, String title, String artist,	String year) {
		String url = 
			"http://localhost:8163/SongService/SongService.groovy";
		Song s = new Song();
		s.setId(id);
		s.setArtist(artist);
		s.setTitle(title);
		s.setYear(year);
		Song2XML converter = new Song2XML();
		URI uri = template.postForLocation(url, converter.song2xml(s));
		if (uri != null) {
			log.info("Location: " + uri.toString());
		} else {
			log.info("No Location header found");
		}
	}
	
	public void deleteSong(String id) {
		String url = 
			"http://localhost:8163/SongService/SongService.groovy?id={id}";
		template.delete(url, id);
	}
	
}
