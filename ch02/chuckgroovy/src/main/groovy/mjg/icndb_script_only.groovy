package mjg

import groovy.json.JsonSlurper

String base = 'http://api.icndb.com/jokes/random?limitTo=[nerdy]'
def json = new JsonSlurper().parseText(base.toURL().text)
println json?.value?.joke