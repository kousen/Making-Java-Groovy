package json 

import groovy.json.JsonSlurper

def url = 'http://api.icndb.com/jokes/random'
def json = new JsonSlurper().parseText(url.toURL().text)
def joke = json?.value?.joke
assert joke
println joke
