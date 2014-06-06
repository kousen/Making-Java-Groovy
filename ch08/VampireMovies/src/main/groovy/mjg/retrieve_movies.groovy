package mjg

import groovy.json.*

String apiKey = new File('rotten_tomatoes_apiKey.txt').text
String url = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apiKey=$apiKey"

def vampMovies = new JsonSlurper().parseText("$url&q=vampire".toURL().text)
println vampMovies.size()
