package mjg.entities

import groovy.transform.ToString;

@ToString(includeNames=true)
class Movie {
    long id
    String title
    int year
    MPAARating mpaaRating
    int runtime
    String criticsConsensus
    Map releaseDates = [:]
    Map<String, Rating> ratings = [:]
    String synopsis
    Map posters = [:]
    List<CastMember> abridgedCast = []
    Map links = [:]
    
    static Movie fromJSON(data) {
        Movie m = new Movie()
        m.id = data.id.toLong()
        m.title = data.title
        m.year = data.year.toInteger()
        switch (data.mpaa_rating) {
            case 'PG-13' : m.mpaaRating = MPAARating.PG_13; break
            case 'NC-17' : m.mpaaRating = MPAARating.NC_17; break
            default :
                m.mpaaRating = MPAARating.valueOf(data.mpaa_rating)
        }
        m.runtime = data.runtime ?: 0
        m.criticsConsensus = data.critics_consensus ?: ''
        data.release_dates.each { k,v ->
            m.releaseDates["$k"] = v
        }
        
        if (data.ratings.critics_rating && data.ratings.critics_score) {
            m.ratings['critics'] = 
                new Rating(rating:data.ratings.critics_rating, score:data.ratings.critics_score.toInteger())
        }
        if (data.ratings.audience_rating && data.ratings.audience_score) {
            m.ratings['audience'] = 
                new Rating(rating:data.ratings.audience_rating, score:data.ratings.audience_score.toInteger())
        }
        
        m.synopsis = data.synopsis
        data.posters.each { k,v ->
            m.posters["$k"] = v.toURL()
        }
        data.abridged_cast.each { c ->
            CastMember cm = new CastMember(name:c.name, id:c.id.toLong())
            c.characters.each { cm.characters << it }
            m.abridgedCast << cm
        }
        data.links.each { k,v ->
            m.links["$k"] = v
        }
        return m
    }
}
