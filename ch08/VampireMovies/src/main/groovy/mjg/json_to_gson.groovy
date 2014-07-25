package mjg

import com.google.gson.Gson
import groovy.transform.ToString

@ToString(includeNames = true)
class Response {
    int total
    Movie[] movies
    Links links
    String link_template
}

@ToString(includeNames = true)
class Links {
    String self
}

@ToString(includeNames = true)
class Movie {
    int id
    String title
    int year
    String mpaa_rating
    int runtime
    Dates release_dates
    Ratings ratings
    String synopsis
    Posters posters
    Cast[] abridged_cast
    MovieLinks links
}

@ToString(includeNames = true)
class MovieLinks {
    String self
    String alternate
    String cast
    String clips
    String reviews
    String similar
}

@ToString(includeNames = true)
class Cast {
    String name
    Long id
    String[] characters
}

@ToString(includeNames = true)
class Posters {
    String thumbnail
    String profile
    String detailed
    String original
}

@ToString(includeNames = true)
class Ratings {
    String critics_rating
    int critics_score
    String audience_rating
    int audience_score
}

@ToString(includeNames = true)
class Dates {
    String theater
    String dvd
}

Gson gson = new Gson()
println gson.fromJson(new File("blazing_saddles.json").text, Response)

