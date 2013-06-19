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

import spock.lang.Specification;

class POJOUnitSpec extends Specification {
    POJO pojo
    
    def setup() {
        pojo = new POJO(one:'1',two:2,three:3.0)
    }
    
    def "initial values set from config"() {
        expect:
        pojo.one == "1"
        pojo.three == 3.0
    }
    
    def "change values via setters"() {
        when:
        pojo.one = "one"
        pojo.three = 333.0
        
        then:
        pojo.one == "one"
        pojo.three == 333.0
    }
    
    def "change two directly"() {
        when: pojo.two = 222
        then: pojo.two == 222
    }
}
