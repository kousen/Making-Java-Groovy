package mjg

import groovy.json.*

String apiKey = new File('rotten_tomatoes_apiKey.txt').text
String base = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?"
String qs = [apiKey:apiKey,
             q: URLEncoder.encode('Blazing Saddles','UTF-8')].collect { it }.join('&')
String url = "$base$qs"
println JsonOutput.prettyPrint(url.toURL().text)
def json = new JsonSlurper().parseText(url.toURL().text)
def movie = json.movies[0]
def allCast = new JsonSlurper().parseText("${movie.links.cast}?apiKey=$apiKey".toURL().text)
println '---------- All Cast ----------'
allCast.cast.each { println it }
println '------------------------------'
assert allCast.cast.find { it.characters =~ /Mongo/ }
