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
package mjg.xml

import mjg.scripting.Location;

class GeocoderV3 {
	def base = 'http://maps.google.com/maps/api/geocode/xml?'

	def fillInLatLng(Location loc) {
        def address = loc.street ? [loc.street, loc.city, loc.state] : [loc.city, loc.state]
		def url = base + [sensor:false,
			address:address.collect { v ->
				URLEncoder.encode(v,'UTF-8')
			}.join(',+')].collect {k,v -> "$k=$v"}.join('&')
		def response = new XmlSlurper().parse(url)
		loc.latitude = response.result.geometry.location.lat.toDouble()
		loc.longitude = response.result.geometry.location.lng.toDouble()
        return loc
	}
}
