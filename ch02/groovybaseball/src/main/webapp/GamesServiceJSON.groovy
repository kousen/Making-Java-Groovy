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
import beans.GameResult;
import beans.Stadium;
import service.GetGameData;
import groovy.json.JsonBuilder

def month = params.month
def day = params.day
def year = params.year

m = month.toInteger() < 10 ? '0' + month : month
d = day.toInteger() < 10 ? '0' + day : day
y = year

results = new GetGameData(month:m,day:d,year:y).games

response.contentType = 'application/json'

def json = new JsonBuilder()
json.games {
	results.each { g ->
		game(
		    outcome:"$g.away $g.aScore, $g.home $g.hScore",
            lat:g.stadium.latitude,
            lng:g.stadium.longitude	
		)
	}
}

out << json.toPrettyString()