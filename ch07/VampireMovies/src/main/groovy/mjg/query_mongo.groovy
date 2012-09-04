package mjg

import com.gmongo.GMongo;

GMongo mongo = new GMongo()
def db = mongo.getDB('movies')

println db.vampireMovies.find().count()
db.vampireMovies.find([critics_consensus : ~/.*/]).each { movie ->
    println "$movie.id $movie.title : $movie.critics_consensus"
}