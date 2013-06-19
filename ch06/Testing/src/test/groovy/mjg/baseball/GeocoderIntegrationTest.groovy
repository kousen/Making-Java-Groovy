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
