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

import grails.test.mixin.TestFor
import org.junit.Before

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Task)
class TaskTests {
    Task task
    
    @Before
    void setUp() {
        Quest q = new Quest(name:'name')
        task = new Task(name:'task',priority:3,startDate:new Date(),endDate:new Date(),completed:false,quest:q)
        mockForConstraintsTests(Task, [task])
    }

    void testValid() {
       assertTrue task.validate()
    }
    
    void testBlankName() {
        task.name = ''
        assertFalse task.validate()
    }
    
    void testBelowMinPriority() {
        task.priority = 0
        assertFalse task.validate()
    }
    
    void testAboveMaxPriority() {
        task.priority = 6
        assertFalse task.validate()
    }
    
    void testValidPriorities() {
        (1..5).each {
            task.priority = it
            assertTrue task.validate()
        }
    }
    
    void testStartDateAfterEndDate() {
        task.startDate = task.endDate + 1
        assertFalse task.validate()
    }
}
