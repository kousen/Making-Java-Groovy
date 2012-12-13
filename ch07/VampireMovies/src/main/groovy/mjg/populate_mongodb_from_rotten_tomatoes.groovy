package mjg

import groovy.json.*
import com.gmongo.GMongo

GMongo mongo = new GMongo()
def db = mongo.getDB('movies')
db.vampireMovies.drop()

def slurper = new JsonSlurper()

def key = new File('mjg/rotten_tomatoes_apiKey.txt').text
def base = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?"
def qs = [apiKey:key, q:'vampire'].collect { it }.join('&')
def url = "$base$qs"
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
