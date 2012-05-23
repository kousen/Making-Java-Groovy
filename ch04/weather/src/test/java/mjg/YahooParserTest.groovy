package mjg

import static org.junit.Assert.*
import org.junit.Test

class YahooParserTest {
    YahooParser yp = new YahooParser()
    
    @Test
    void testCityState() {
        yp.woeid = '2445916'
        Weather w = yp.weather
        assert 'Marlborough' == w.city
        assert 'CT' == w.region
        assert 'United States' == w.country
    }
}