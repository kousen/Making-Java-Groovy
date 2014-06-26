package mjg

import com.gmongo.GMongo
import groovy.json.JsonSlurper

GMongo mongo = new GMongo()
def db = mongo.getDB('movies')
int before = db.otherMovies?.find().count()

def blazingSaddles = new JsonSlurper().parseText(
        new File('blazing_saddles.json').text).movies

println blazingSaddles.title[0]

if (!db.otherMovies.findOne(title:'Blazing Saddles')) {
    db.otherMovies << blazingSaddles
    int after = db.otherMovies.find().count()
    assert after == before + 1
}

assert db.otherMovies.findOne(title:'Blazing Saddles')