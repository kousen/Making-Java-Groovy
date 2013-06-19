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

class Weather {
    String location
    String time
    String wind
    String visibility
    String conditions
    String temperature
    String dewPoint
    String relativeHumidity
    String pressure
    
    String toString() {
        return """Weather for $location:
            Time: $time, 
            Wind: $wind,
            Visibility: $visibility,
            Conditions: $conditions,
            Temperature: $temperature,
            Dew Point: $dewPoint,
            Humidity: $relativeHumidity,
            Pressure: $pressure
        """
    }
}
