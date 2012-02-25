package mjg;

import static org.junit.Assert.assertEquals;

import java.util.List;

import mjg.Song;
import mjg.SongClient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SongClientTest {
	@Autowired
	private SongClient client;
	
	@Before
	public void setUp() {
		List<Song> songs = client.getSongs();
		for (Song s : songs) {
			client.deleteSong(s.getId());
		}
	}
	
	@After
	public void tearDown() {
		List<Song> songs = client.getSongs();
		for (Song s : songs) {
			client.deleteSong(s.getId());
		}		
	}

	@Test
	public void testGetSongs() {
		List<Song> before = client.getSongs();
		assertEquals(0,before.size());
		client.addSong("1", "Feeling Groovy", "Simon and Garfunkel", "1966");
		client.addSong("2", "Groovin'", "The Young Rascals", "1967");
		client.addSong("3", "Groovy Kind of Love", "Phil Collins (cover)", "1988");
		List<Song> after = client.getSongs();
		assertEquals(3, after.size());
	}
	
	@Test
	public void testGetSongById() {
		client.addSong("1", "Feeling Groovy", "Simon and Garfunkel", "1966");
		Song s = client.getSongById("1");
		assertEquals("1",s.getId());
		assertEquals("Feeling Groovy",s.getTitle());
		assertEquals("Simon and Garfunkel",s.getArtist());
		assertEquals("1966",s.getYear());
	}

	@Test
	public void testAddSong() {
		client.addSong("1", "Feeling Groovy", "Simon and Garfunkel", "1966");
		List<Song> songs = client.getSongs();
		assertEquals(1,songs.size());
		Song s = songs.get(0);
		assertEquals("Feeling Groovy",s.getTitle());
		assertEquals("Simon and Garfunkel",s.getArtist());
		assertEquals("1966",s.getYear());
		assertEquals("1", s.getId());
	}

	@Test
	public void testDeleteSong() {
		client.addSong("1", "Ruby Tuesday", "The Rolling Stones", "1967");
		List<Song> songs = client.getSongs();
		assertEquals(1, songs.size());
		client.deleteSong("1");
		songs = client.getSongs();
		assertEquals(0, songs.size());
	}
}
