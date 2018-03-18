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

import groovy.json.JsonSlurper;
import groovy.sql.Sql;

import java.util.logging.Logger;
import java.util.regex.Matcher;

import beans.GameResult;
import beans.Stadium;

class GetGameData {
    def day
    def month
    def year
    String base = 'http://gd.mlb.com/components/game/mlb/'
    Map stadiumMap = [:]
    
    Map abbrevs = [
        ana:'Los Angeles (A)', ari:'Arizona',     atl:'Atlanta',
        bal:'Baltimore',       bos:'Boston',      cha:'Chicago (A)',
        chn:'Chicago (N)',     cin:'Cincinnati',  cle:'Cleveland',
        col:'Colorado',        det:'Detroit',     flo:'Florida',
        hou:'Houston',         kca:'Kansas City', lan:'Los Angeles (N)',
        mil:'Milwaukee',       min:'Minnesota',   nya:'New York (A)',
        nyn:'New York (N)',    oak:'Oakland',     phi:'Philadelphia',
        pit:'Pittsburgh',      sdn:'San Diego',   sea:'Seattle',
        sfn:'San Francisco',   sln:'St. Louis',   tba:'Tampa Bay',
       	tex:'Texas',           tor:'Toronto',     was:'Washington']

    GetGameData() {
        fillInStadiumMap()
    }
    
    def fillInStadiumMap() {
        Sql db = Sql.newInstance(
            'jdbc:h2:build/baseball',
            'org.h2.Driver'
        )
        db.eachRow("select * from stadium") { row ->
            Stadium stadium = new Stadium(
                name:row.name, 
                team:row.team,
                latitude:row.latitude, 
                longitude:row.longitude
            )
            stadiumMap[stadium.team] = stadium
        }
        db.close()
    }

    GameResult getGame(String game_data_directory) {
        def gid = game_data_directory[-30..-1]
        def pattern = /gid_\w{4}_\w{2}_\w{2}_(\w{3})\w{3}_(\w{3})mlb_(\d)/
        Matcher m = gid =~ pattern

        if (!m) {
            println "$gid unavailable"
            return null
        }

        String away = m[0][1]
        String home = m[0][2]
        String num = m[0][3]

        println "${abbrevs[away]} at ${abbrevs[home]} on $month/$day/$year"
        String game = "http://gd.mlb.com$game_data_directory"
        def boxscore = new XmlSlurper().parse("$game/boxscore.xml")

        GameResult result = new GameResult(
            home:   boxscore.@home_fname,
            away:   boxscore.@away_fname,
            hScore: boxscore.linescore[0].@home_team_runs,
            aScore: boxscore.linescore[0].@away_team_runs,
            stadium:stadiumMap[home]
        )
        println "$result.away $result.aScore, $result.home $result.hScore (game $num)"
        def pitchers = boxscore.pitching.pitcher
        pitchers.each { p ->
            if (p.@note && p.@note =~ /W|L|S/) {
                println "  ${p.@name} ${p.@note}"
            }
        }
        return result
    }

    def getGames() {
        def gameResults = []
        println "Games for ${month}/${day}/${year}"

        String base = 'http://gd.mlb.com/components/game/mlb/'
        String date = "year_${year}/month_${month}/day_${day}"
        def master = new JsonSlurper().parse("$base$date/master_scoreboard.json".toURL())
        def games = master.data.games.game

        return games.collect { getGame(it.game_data_directory) }
                    .findAll { it }

//        String url = base + "year_$year/month_$month/day_$day/"
//        String gamePage = url.toURL().text
//        def pattern = /\"gid_${year}_${month}_${day}_(\w*)mlb_(\w*)mlb_(\d)/
//
//        Matcher m = gamePage =~ pattern
//        if (m) {
//            m.count.times { line ->
//                String away = m[line][1]
//                String home = m[line][2]
//                String num = m[line][3]
//                try {
//                    GameResult gr = this.getGame(away,home,num)
//                    gameResults << gr
//                } catch (Exception e) {
//                    println "${abbrevs[away]} at ${abbrevs[home]} not started yet"
//                }
//            }
//        }
//        return gameResults
    }
}
