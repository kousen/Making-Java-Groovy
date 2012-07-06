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
