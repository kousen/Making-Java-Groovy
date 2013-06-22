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

class YahooParser {
    final static String BASE = 'http://weather.yahooapis.com/forecastrss?'
    
    Weather getWeather(String woeid) {
        def root = new XmlSlurper().parse(BASE + "w=$woeid")
        Weather w = new Weather(
            city:root.channel.location.@city,
            region:root.channel.location.@region,
            country:root.channel.location.@country,
            condition:root.channel.item.condition.@text,
            temp:root.channel.item.condition.@temp,
            chill:root.channel.wind.@chill,
            humidity:root.channel.atmosphere.@humidity
        )
    }
}