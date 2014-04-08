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
package mjg.ast.immutable;

import spock.lang.Specification

class ImmutableLineSpec extends Specification {
    ImmutableLine line
    
    def setup() {
        ImmutablePoint p1 = new ImmutablePoint(x:3,y:0)
        ImmutablePoint p2 = new ImmutablePoint(x:0,y:4)
        line = new ImmutableLine(start:p1,end:p2)
    }
    
    def "points should be set properly"() {
        expect:
        line.start.x == 3
        line.start.y == 0
        line.end.x == 0
        line.end.y == 4
        Math.abs(line.length - 5) < 0.0001 
    }
    
    def "can't change start"() {
        when: line.start = new ImmutablePoint(x:1,y:1)
        then: thrown(ReadOnlyPropertyException)
    }

    def "can't change end"() {
        when: line.end = new ImmutablePoint(x:1,y:1)
        then: thrown(ReadOnlyPropertyException)
    }

}
