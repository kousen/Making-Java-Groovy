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
package json 

import groovy.json.JsonSlurper
import groovy.json.JsonException

def url = 'http://api.icndb.com/jokes/random'
try {
    def json = new JsonSlurper().parseText(url.toURL().text)
    def joke = json?.value?.joke
    assert joke
    println joke
} catch (JsonException e) {
    e.printStackTrace()
}
