package mjg.baseball;

import static org.junit.Assert.*
import groovy.mock.interceptor.StubFor

import org.junit.Test

class GeocoderUnitTest {
    Geocoder geocoder = new Geocoder()
    
    @Test
    public void testFillInLatLng() {
        Stadium wrongStadium = new Stadium(
            street:'1313 Mockingbird Lane',
            city:'Mockingbird Heights',state:'CA')
        
        String xml = '''
        <root><result><geometry>
            <location>
                <lat>37.422</lat>
                <lng>-122.083</lng>
            </location>
        </geometry></result></root>'''
        
        def correctRoot = new XmlSlurper().parseText(xml)
        
        def stub = new StubFor(XmlSlurper)
        stub.demand.parse { correctRoot }
        
        stub.use {
            geocoder.fillInLatLng(wrongStadium)
        }
        assertEquals(37.422, wrongStadium.latitude, 0.01)
        assertEquals(-122.083, wrongStadium.longitude, 0.01)
    }
}
