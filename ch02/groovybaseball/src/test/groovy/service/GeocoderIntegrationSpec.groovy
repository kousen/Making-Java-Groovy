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
package service;

import spock.lang.Specification
import beans.Stadium

class GeocoderIntegrationSpec extends Specification {
    Stadium stadium
    Geocoder geocoderXml
    GeocoderJSON geocoderJson
    
    def setup() {
        stadium = new Stadium(street:'1600 Ampitheatre Parkway',
            city:'Mountain View',state:'CA')
        geocoderXml = new Geocoder()
        geocoderJson = new GeocoderJSON()
    }
    
    def "fill in lat,lng using XML parsing"() {
        given:
        def google_lat = 37.422
        def google_lng = -122.083
        
        when:
        geocoderXml.fillInLatLng(stadium)

        then:
        Math.abs(stadium.latitude - google_lat) < 0.01
        Math.abs(stadium.longitude - google_lng) < 0.01
    }

    def "fill in lat,lng using JSON parsing"() {
        given:
        def google_lat = 37.422
        def google_lng = -122.083
        
        when:
        geocoderJson.fillInLatLng(stadium)

        then:
        Math.abs(stadium.latitude - google_lat) < 0.01
        Math.abs(stadium.longitude - google_lng) < 0.01
    }

}
