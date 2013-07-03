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
package mjg

class GeocoderService {

    String base = 'http://maps.googleapis.com/maps/api/geocode/xml?'
    
    def columns = [['number','Lat'],['number','Lon'],['string','Name']]

    def fillInLatLng(Castle castle) {
        def encodedAddress =
            [castle.city, castle.state].collect {
                URLEncoder.encode(it, 'UTF-8')
            }.join(',+')
        def url = base +
            [address: encodedAddress, sensor: false].collect { k,v ->
                "$k=$v"
            }.join('&')
        def root = new XmlSlurper().parse(url)
        castle.latitude = root.result.geometry.location.lat[0].toDouble()
        castle.longitude = root.result.geometry.location.lng[0].toDouble()
    }
    
    def getMarkers() {
        Castle.list().collect { c ->
            [c.latitude, c.longitude, c.toString()]
        }
    }
}
