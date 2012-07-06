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
package service
import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class GameServiceIntegrationTests {
	@Test
	void testGameService() {
		String response = 
			"http://localhost:8080/groovybaseball/GamesService.groovy?month=10&day=28&year=2007".toURL().text
		def games = new XmlSlurper().parseText(response)
		assert 1 == games.game.size()
		assert games.game[0].@outcome.toString().contains('Boston')
		assert games.game[0].@outcome.toString().contains('Colorado')
	}
	
	@Test
	void testGameServiceJSON() {
		String response = 
			"http://localhost:8080/groovybaseball/GamesServiceJSON.groovy?month=10&day=28&year=2007".toURL().text
		println response
		def json = new groovy.json.JsonSlurper().parseText(response)
		println json
		assert json.games.game.outcome.toString().contains('Boston')
		assert json.games.game.outcome.toString().contains('Colorado')
	}
}