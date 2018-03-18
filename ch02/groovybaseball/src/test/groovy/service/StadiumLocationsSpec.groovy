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
package service

import spock.lang.Shared;
import spock.lang.Specification;
import spock.lang.Unroll;
import groovy.sql.Sql

class StadiumLocationsSpec extends Specification {
    @Shared Sql db
    
    def setupSpec() {
        db = Sql.newInstance(
            'jdbc:h2:build/baseball', 
            'org.h2.Driver')
    }
    
    @Unroll
    def "#name: #lat and #lng in range"(String name, double lat, double lng) {
        expect:
        lat > 25 && lat < 48
        lng > -123 && lng < -71
        
        where:
        [name,lat,lng] << db.rows('select name,latitude,longitude from stadium')
    }

    def cleanupSpec() {
        if (db) db.close()
    }
}
