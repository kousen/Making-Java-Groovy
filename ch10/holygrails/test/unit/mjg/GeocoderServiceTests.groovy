package mjg

import grails.test.mixin.TestFor
//import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(GeocoderService)
class GeocoderServiceTests {

    void testGoogleHeadquarters() {
        Castle google = new Castle(name: 'Google', 
            city: 'Mountain View', state: 'CA')
        GeocoderService gs = new GeocoderService()
        assertEquals(0.0, google.latitude, 0.1)
        assertEquals(0.0, google.longitude, 0.1)
        
        gs.fillInLatLng(google)

        assertEquals(37.4, google.latitude, 0.1)
        assertEquals(-122.1, google.longitude, 0.1)
    }
}
