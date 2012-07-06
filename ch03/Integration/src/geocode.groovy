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
def address = [street,city,state].collect {
	URLEncoder.encode(it,'UTF-8')
}.join(',+')
def params = [q:address,sensor:false,
	output:'csv',
	key:'ABQIAAAAaUTtvoQeYKO5TqAv0hl2QxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxTU9rH8s89rxCtRwCKUkQ3Q6sYsNg']
def base = 'http://maps.google.com/maps/geo?'
def url = base + params.collect { k,v -> "$k=$v" }.join('&')
(code,level,lat,lng) = url.toURL().text.split(',')
//println "($code,$level,$lat,$lng)"