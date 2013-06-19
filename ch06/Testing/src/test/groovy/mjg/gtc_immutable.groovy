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

class ImmutablePointTests extends GroovyTestCase {
    Point p = new Point(x:3,y:4)
    
    void testInitializationWorked() {
        assert p.x == 3
        assert p.y == 4
    }
    
    void testCantChangeX() {
        shouldFail(ReadOnlyPropertyException) {
            p.x = 99
        }
    }

    void testCantChangeY() {
        shouldFail(ReadOnlyPropertyException) {
            p.y = 99
        }
    }
}

@groovy.transform.Immutable
class Point {
    double x
    double y
}