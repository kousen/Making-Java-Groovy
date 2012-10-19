package mjg

import groovy.json.*

println new File('.').list()
def apiKey = new File('mjg/rotten_tomatoes_apiKey.txt').text
def url = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apiKey=$apiKey"

def vampMovies = new JsonSlurper().parseText("$url&q=vampire".toURL().text)
println vampMovies.size()
