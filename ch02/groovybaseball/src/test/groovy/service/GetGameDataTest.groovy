package service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import beans.GameResult;
import beans.Stadium;

class GetGameDataTest {
	GetGameData ggd
	
	@Before
	public void setUp() throws Exception {
		ggd = new GetGameData(month:10,day:28,year:2007)
	}

	@Test
	public void testFillInStadiumMap() {
		assertEquals 0, ggd.stadiumMap.size()
		ggd.fillInStadiumMap()
		def stadiums = ggd.stadiumMap.values()
		stadiums.each { Stadium stadium ->
			assertTrue stadium.latitude > 25 && stadium.latitude < 48
			assertTrue stadium.longitude > -123 && stadium.longitude < -71
		}
	}

	@Test
	public void testGetGame() {
		GameResult gr = ggd.getGame 'bos','col','1'
		assertEquals 'Boston Red Sox', gr.away
		assertEquals 'Colorado Rockies', gr.home
		assertEquals 4, gr.aScore.toInteger()
		assertEquals 3, gr.hScore.toInteger()
	}

	@Test
	public void testGetGames() {
		def gameResults = ggd.getGames()
		assertEquals 1, gameResults.size()
	}

}
