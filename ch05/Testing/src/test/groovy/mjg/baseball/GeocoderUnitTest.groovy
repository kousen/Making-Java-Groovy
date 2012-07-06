/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
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
