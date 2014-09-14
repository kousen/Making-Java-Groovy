package mjg

import mjg.entities.Movie;

import com.gmongo.GMongo;

GMongo mongo = new GMongo()
def db = mongo.getDB('movies')

println db.vampireMovies.find().count()
db.vampireMovies.find(critics_consensus : ~/.*/).each { movie ->
    println "$movie.id $movie.title : $movie.critics_consensus"
    //println Movie.fromJSON(movie)
}

//def bs = db.otherMovies.findOne(title: 'Blazing Saddles')
//println bs
//println Movie.fromJSON(bs)