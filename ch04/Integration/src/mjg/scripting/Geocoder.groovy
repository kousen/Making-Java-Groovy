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

class Geocoder {
    def base = 'http://maps.google.com/maps/geo?'
    
    void fillInLatLong(Location loc) {
        def addressFields = loc.street ? 
            [loc.street,loc.city,loc.state] : [loc.city,loc.state]
        def address = addressFields.collect {
            URLEncoder.encode(it,'UTF-8')
        }.join(',+')
        def params = [q:address,sensor:false,
            output:'csv',
            key:'ABQIAAAAaUTtvoQeYKO5TqAv0hl2QxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxTU9rH8s89rxCtRwCKUkQ3Q6sYsNg']
        def url = base + params.collect { k,v -> "$k=$v" }.join('&')
        def (ok,mag,lat,lng) = url.toURL().text.split(',')
        loc.latitude = lat.toDouble()
        loc.longitude = lng.toDouble()
    }
}
