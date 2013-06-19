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

import groovy.util.XmlSlurper;
import net.webservicex.GlobalWeather
import net.webservicex.GlobalWeatherSoap

class GlobalWeatherClient {
    GlobalWeatherSoap stub = new GlobalWeather().globalWeatherSoap
    
    int countAvailableCitiesInCountry(countryName) {
        return getCitiesInCountry(countryName).size()
    }
    
    def getCitiesInCountry(countryName) {
        def results = new XmlParser().parseText(stub.getCitiesByCountry(countryName))
        return results.Table.City*.text()
    }
    
    String getXMLWeather(city,country) {
        return stub.getWeather(city,country)
    }
    
    Weather getWeather(city,country) {
        def results = new XmlSlurper().parseText(stub.getWeather(city, country))
        return new Weather(
            location:results.Location,
            time:results.Time,
            wind:results.Wind,
            visibility:results.Visibility,
            conditions:results.SkyConditions,
            temperature:results.Temperature,
            dewPoint:results.DewPoint,
            relativeHumidity:results.RelativeHumidity,
            pressure:results.Pressure
        )
    }
}
