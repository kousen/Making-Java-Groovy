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
	GetGameData ggd = new GetGameData(month:'03',day:'28',year:'2015')

	@Test
	public void testFillInStadiumMap() {
		def stadiums = ggd.stadiumMap.values()
		stadiums.each { Stadium stadium ->
			assert stadium.latitude > 25 && stadium.latitude < 48
			assert stadium.longitude > -123 && stadium.longitude < -71
		}
	}

	@Test
	public void testGetGame() {
		GameResult gr = ggd.getGame('/components/game/mlb/year_2007/month_10/day_28/gid_2007_10_28_bosmlb_colmlb_1')
		assert 'Boston Red Sox' == gr.away
		assert 'Colorado Rockies' == gr.home
		assert 4 == gr.aScore.toInteger()
		assert 3 == gr.hScore.toInteger()
	}

	@Test
	public void testGetGames() {
		def gameResults = ggd.games
		assert 17 == gameResults.size()
	}

}
