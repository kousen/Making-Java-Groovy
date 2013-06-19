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
package mjg.soap.client

import spock.lang.Specification;

class GlobalWeatherClientTests extends Specification {
    GlobalWeatherClient client
    
    def setup() {
        client = new GlobalWeatherClient()
    }
    
    def "at least 561 cities in Canada"() {
        expect:
        client.countAvailableCitiesInCountry('Canada') >= 561
    }
    
    def "Australian cities includes Sydney Airport"() {
        expect:
        client.getCitiesInCountry("Australia").contains 'Sydney Airport'
    }
    
    def "Weather for Boston, MA"() {
        when:
        Weather w = client.getWeather('Boston', "United States")
        println w
        
        then:
        w.location ==~ /.*BOSTON.*/
    }
}
