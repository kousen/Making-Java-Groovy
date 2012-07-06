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
package service

import groovy.mock.interceptor.StubFor
import spock.lang.Ignore;
import spock.lang.Specification
import beans.Stadium

class GeocoderUnitSpec extends Specification {
    Stadium stadium
    Geocoder geocoder
    String xml = '''
        <root><result><geometry>
            <location>
                <lat>37.422</lat>
                <lng>-122.083</lng>
            </location>
        </geometry></result></root>'''


    def setup() {
        stadium = new Stadium(street:'1313 Mockingbird Lane',
            city:'New York',state:'NY')
        geocoder = new Geocoder()
    }

    def "check with stubbed XmlSlurper"() {
        given:
        // parse the text given above
        def root = new XmlSlurper().parseText(xml)

        // mock the slurper for the geocoder
        def stub = new StubFor(XmlSlurper)
        stub.demand.parse { root }

        when:
        stub.use { geocoder.fillInLatLng(stadium) }

        then:
        Math.abs(stadium.latitude - 37.422) < 0.01
        Math.abs(stadium.longitude - -122.083) < 0.01
        stub.verify()
    }
}
