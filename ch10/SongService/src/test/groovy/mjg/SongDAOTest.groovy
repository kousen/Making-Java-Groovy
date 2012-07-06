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