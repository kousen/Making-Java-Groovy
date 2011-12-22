package mjg.baseball;

import static org.junit.Assert.*;

import org.junit.Test;

class GeocoderIntegrationTest {
    Geocoder geocoder = new Geocoder()
    
    @Test
    public void testFillInLatLng() {
        Stadium google = new Stadium(street:'1600 Ampitheatre Parkway',
            city:'Mountain View',state:'CA')
        geocoder.fillInLatLng(google)
        assertEquals(37.422, google.latitude, 0.01)
        assertEquals(-122.083, google.longitude, 0.01)
    }

}
