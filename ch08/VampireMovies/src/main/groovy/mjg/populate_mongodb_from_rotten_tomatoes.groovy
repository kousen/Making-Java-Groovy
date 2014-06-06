package mjg

import groovy.json.*
import com.gmongo.GMongo

GMongo mongo = new GMongo()
def db = mongo.getDB('movies')
db.vampireMovies.drop()

def slurper = new JsonSlurper()

String key = new File('rotten_tomatoes_apiKey.txt').text
String base = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?"
String qs = [apiKey:key, q:'vampire'].collect { it }.join('&')
String url = "$base$qs"
println url
def vampMovies = new JsonSlurper().parseText(url.toURL().text)
db.vampireMovies << vampMovies.movies
def next = vampMovies?.links?.next

while (next) {
    println next
    vampMovies = slurper.parseText("$next&apiKey=$key".toURL().text)
    db.vampireMovies << vampMovies.movies
    next = vampMovies?.links?.next
}

println db.vampireMovies.find().count()
