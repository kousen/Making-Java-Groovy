package mjg

import groovy.json.JsonOutput
import groovy.json.JsonSlurper;

def url = 'http://api.icndb.com/jokes/random'
def result = '''
{
    "value" : {
        "joke" : "Chuck Norris can make a class abstract AND final"
    }
}
'''
try {
    result = url.toURL().text
} catch (UnknownHostException e) {
    println 'Service not available'
}
println JsonOutput.prettyPrint(result)
def json = new JsonSlurper().parseText(result)
def joke = json?.value?.joke
assert joke
println joke