package service;

import java.util.logging.Logger;

import beans.GameResult;
import beans.Stadium;

class GetGameData {
    def day
    def month
    def year
    def base = 'http://gd2.mlb.com/components/game/mlb/'
    def stadiumMap = [:]
    
    private static Logger logger = Logger.getLogger(GetGameData.class.name)

    def abbrevs = [
        ana:"Los Angeles (A)",ari:"Arizona",atl:"Atlanta",
        bal:"Baltimore",bos:"Boston",cha:"Chicago (A)",
        chn:"Chicago (N)",cin:"Cincinnati",cle:"Cleveland",
        col:"Colorado",det:"Detroit",flo:"Florida",
        hou:"Houston",kca:"Kansas City",lan:"Los Angeles (N)",
        mil:"Milwaukee",min:"Minnesota",nya:"New York (A)",
        nyn:"New York (N)",oak:"Oakland",phi:"Philadelphia",
        pit:"Pittsburgh",sdn:"San Diego",sea:"Seattle",
        sfn:"San Francisco",sln:"St. Louis",tba:"Tampa Bay",
       	tex:"Texas",tor:"Toronto",was:"Washington"]

    def fillInStadiumMap() {
        def db = groovy.sql.Sql.newInstance(
            'jdbc:h2:~/build/baseball',
            'org.h2.Driver'
        )
        logger.info "Value of db after newInstance is $db"
        db.eachRow("select * from stadium") { row ->
            def home = row.team
            stadiumMap[home] =
            new Stadium(name:row.name,
                team:home,
                latitude:row.latitude,
                longitude:row.longitude
            )
        }
        db.close()
    }

    def getGame(away, home, num) {
        println "${abbrevs[away]} at ${abbrevs[home]} on ${month}/${day}/${year}"
        def url = base + "year_${year}/month_${month}/day_${day}/"
        def game = "gid_${year}_${month}_${day}_${away}mlb_${home}mlb_${num}/boxscore.xml"
        def boxscore = new XmlParser().parse(url + game)
        def awayName = boxscore.@away_fname
        def awayScore = boxscore.linescore[0].@away_team_runs
        def homeName = boxscore.@home_fname
        def homeScore = boxscore.linescore[0].@home_team_runs
        println "$awayName $awayScore, $homeName $homeScore (game $num)"
        def pitchers = boxscore.pitching.pitcher
        pitchers.each { p ->
            if (p.@note && p.@note =~ /W|L|S/) {
                println "  ${p.@name} ${p.@note}"
            }
        }
        GameResult result =
        new GameResult(home:homeName,
            away:awayName,
            hScore:homeScore,
            aScore:awayScore,
            stadium:stadiumMap[home]
        )
        return result
    }

    def getGames() {
        if (stadiumMap.size() == 0) fillInStadiumMap()
        def gameResults = []
        println "Games for ${month}/${day}/${year}"
        def url = base + "year_${year}/month_${month}/day_${day}/"
        def gamePage = url.toURL().text
        def pattern = /\"gid_${year}_${month}_${day}_(\w*)mlb_(\w*)mlb_(\d)/

        def m = gamePage =~ pattern
        if (m) {
            (0..<m.count).eachWithIndex { line, i ->
                def away = m[line][1]
                def home = m[line][2]
                def num = m[line][3]
                try {
                    def gr = this.getGame(away,home,num)
                    gameResults << gr
                } catch (Exception e) {
                    println abbrevs[away] + " at " +
                    abbrevs[home] + " not started yet"
                }
            }
        }
        return gameResults
    }
}
