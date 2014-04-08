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

class ImmutablePathSpec extends Specification {
    ImmutablePath path
    
    def setup() {
        def lines = []
        ImmutablePoint p1 = new ImmutablePoint(x:0,y:0)
        ImmutablePoint p2 = new ImmutablePoint(x:3,y:0)
        ImmutablePoint p3 = new ImmutablePoint(x:0,y:4)
        lines << new ImmutableLine(start:p1,end:p2)
        lines << new ImmutableLine(start:p2,end:p3)
        lines << new ImmutableLine(start:p3,end:p1)
        
        path = new ImmutablePath(segments:lines)
    }    

    def "points should be set through ctor"() {
        println path.segments.class.name
        
        expect:
        path.segments.collect { line -> line.start.x } == [0,3,0]
        path.segments.collect { line -> line.start.y } == [0,0,4]
        path.segments.collect { line -> line.end.x } == [3,0,0]
        path.segments.collect { line -> line.end.y } == [0,4,0]
    }
    
    def "cant add new segments"() {
        given:
        ImmutablePoint a = new ImmutablePoint(x:5,y:5)
        ImmutablePoint b = new ImmutablePoint(x:4,y:4)
        
        when:
        path.segments << new ImmutableLine(start:a,end:b)
        
        then:
        thrown UnsupportedOperationException
    }
}
