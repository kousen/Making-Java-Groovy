import beans.GameResult;
import beans.Stadium;
import service.GetGameData;

response.contentType = 'text/xml'
def month = params.month
def day = params.day
def year = params.year

m = month.toInteger() < 10 ? '0' + month : month
d = day.toInteger() < 10 ? '0' + day : day
y = year

results = new GetGameData(month:m,day:d,year:y).games

html.games {
    results.each { g ->
        game(
            outcome:"$g.away $g.aScore, $g.home $g.hScore",
            lat:g.stadium?.latitude,
            lng:g.stadium?.longitude
        )
    }
}
