package mjg

import groovy.json.*

def apiKey = new File('mjg/rotten_tomatoes_apiKey.txt').text
def base = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?"
def qs = [apiKey:apiKey, q: URLEncoder.encode('Blazing Saddles','UTF-8')].collect { it }.join('&')
def url = "$base$qs"
def json = new JsonSlurper().parseText(url.toURL().text)
def movie = json.movies[0]
// println JsonOutput.prettyPrint(JsonOutput.toJson(movie))
def allCast = new JsonSlurper().parseText("${movie.links.cast}?apiKey=$apiKey".toURL().text)
println '---------- All Cast ----------'
allCast.cast.each { println it }
println '------------------------------'
def actor = allCast.cast.find { it.characters =~ /Mongo/ }
