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

// Marlborough, CT:  2445916
// York, PA       :  2524847
// Boston, MA     :  2367105
// London, UK     :  44418
// Paris, FR      :  615702
// Los Angeles, CA:  2442047
// Brisbane, AU   :  1100661

def woeid = args.size() ? args[0] : '2367105'
println new YahooParser().getWeather(woeid)
