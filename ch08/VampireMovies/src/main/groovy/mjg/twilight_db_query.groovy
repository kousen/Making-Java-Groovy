package mjg

import mjg.entities.Movie;

import com.gmongo.GMongo;

GMongo mongo = new GMongo()
def db = mongo.getDB('movies')

// Twilight series: Twilight, New Moon, Eclipse, Breaking Dawn
def results = db.vampireMovies.find().findAll {
    it.title =~ /Twilight|Dawn|Eclipse|Moon/
}*.title
println "Twilight series movies in DB: $results"