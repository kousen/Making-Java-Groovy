package mjg.entities;

import static org.junit.Assert.*;
import groovy.json.JsonSlurper;

import org.junit.Test;

class MovieTest {
    @Test
    public void testFromJSON() {
        def data = new JsonSlurper().parseText(
			new File('src/main/groovy/mjg/blazing_saddles.json').text)
        Movie.fromJSON(data.movies[0]).with {
			assert id == 13581
			assert title == 'Blazing Saddles'
			assert year == 1974
			assert mpaaRating == MPAARating.R
			assert runtime == 93
			assert releaseDates == ['theater':'1974-02-07', 'dvd':'1997-08-27']
			assert ratings['critics'].rating == 'Certified Fresh'
			assert ratings['critics'].score == 89
			assert ratings['audience'].rating == 'Upright'
			assert ratings['audience'].score == 89
			assert synopsis == ''
			assert posters.size() == 4
			assert abridgedCast.size() == 5
			assert abridgedCast[0].name == 'Cleavon Little'
			assert abridgedCast[0].id == 162693977
			assert abridgedCast[0].characters == ['Bart']
			assert links.size() == 6
        }
    }

}
