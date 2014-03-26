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
package mjg.scripting

import groovy.util.slurpersupport.GPathResult

class GeocoderV3 {
    def base = 'http://maps.googleapis.com/maps/api/geocode/xml?'
    
    void fillInLatLong(Location loc) {
        def addressFields = loc.street ? 
            [loc.street,loc.city,loc.state] : [loc.city,loc.state]
        def encoded = addressFields.collect {
            URLEncoder.encode(it,'UTF-8')
        }.join(',')
        def params = [address: encoded, sensor: false]
        def url = base + params.collect { k,v -> "$k=$v" }.join('&')
        GPathResult root = new XmlSlurper().parse(url)
		loc.latitude = root.result[0].geometry.location.lat.toDouble()
        loc.longitude = root.result[0].geometry.location.lng.toDouble()
    }
}
