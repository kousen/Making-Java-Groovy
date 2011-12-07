package mjg.xml;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import mjg.scripting.Location

class GeocoderV3Test {
    Location loc
    GeocoderV3 geocoder
    
    @Before
    void setUp() {
        loc = new Location(street:'1600 Ampitheatre Parkway',
            city:'Mountain View',state:'CA')
        geocoder = new GeocoderV3()
    }
    
    @Test
    void testFillInLatLng() {
        assertTrue loc.latitude < 0.1
        assertTrue loc.longitude < 0.1
        loc = geocoder.fillInLatLng(loc)
        def google_lat = 37.422
        def google_lng = -122.083
        assertTrue Math.abs(loc.latitude - google_lat) < 0.01
        assertTrue Math.abs(loc.longitude - google_lng) < 0.01
    }

}
