package mjg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class SongDAOTest {
	SongDAO dao
	
	@Before
	public void setUp() throws Exception {
		dao = SongDAO.instance
	}
	
	@Test
	public void testAddSong() {
		assertFalse dao.exists("1")
		Song s = new Song(id:'1',title:'title',artist:'artist',year:'year')
		dao.addSong s
		assertTrue dao.exists('1')
	}
	
	@Test
	public void testGetSong() {
		Song s = new Song(id:'1',title:'title',artist:'artist',year:'year')
		dao.addSong s
		Song s1 = dao.getSong('1')
		assertEquals(s,s1)
	}
	
	@Test
	public void testGetAllSongs() {
		Song s1 = new Song(id:'1',title:'title1',artist:'artist1',year:'year1')
		Song s2 = new Song(id:'2',title:'title2',artist:'artist2',year:'year2')
		dao.addSong s1
		dao.addSong s2
		def songs = dao.getAllSongs()
		assertEquals 2, songs.size()
	}
	
	@Test
	public void testDeleteSong() {
		Song s = new Song(id:'1',title:'title',artist:'artist',year:'year')
		dao.addSong s
		assertTrue dao.exists('1')
		dao.deleteSong '1'
		assertFalse dao.exists('1')
	}
	
	
	@Test
	public void testExists(){
		Song s = new Song(id:'1',title:'title',artist:'artist',year:'year')
		dao.addSong s
		assertTrue dao.exists('1')
	}
	
	@Test
	public void testDeleteTwiceReturnsSameValue() {
		Song s = new Song(id:'1',title:'title',artist:'artist',year:'year')
		dao.addSong s
		dao.deleteSong('1')
		dao.deleteSong('1')
	}
}