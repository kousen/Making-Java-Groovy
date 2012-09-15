package mjg

import groovy.json.*

def apiKey = '3ufhgmk2h9yf4ksn2mh8zahv'
def url = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apiKey=$apiKey"

def vampMovies = new JsonSlurper().parseText("$url&q=vampire".toURL().text)
println vampMovies.size()
