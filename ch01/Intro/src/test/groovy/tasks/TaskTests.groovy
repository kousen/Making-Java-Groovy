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
package tasks

import spock.lang.Specification;

class TaskTests extends Specification {
    JavaTask jtask = new JavaTask(name:'name', priority:1,
        startDate:new Date(), endDate:new Date() + 1)

    GroovyTask gtask = new GroovyTask(name:'name', priority:1,
            startDate:new Date(), endDate:new Date() + 1)
    
    def "groovy and java tasks are equivalent"() {
        expect:
        jtask.name == gtask.name
        jtask.priority == gtask.priority
        (jtask.startDate - gtask.startDate).abs() < 1
        (jtask.endDate - gtask.endDate).abs() < 1
    }
    
    def 'groovy tasks have equals method'() {
        given:
        GroovyTask gtaskcopy = new GroovyTask('name', 1,
            gtask.startDate, gtask.endDate)
        GroovyTask gtaskother = new GroovyTask(name:'name', priority:2,
            startDate:new Date(), endDate:new Date() + 1)
        
        expect:
        gtask == gtaskcopy
        gtask != gtaskother
    }
    
    def 'check hashCode and equals through Set'() {
        given:
        GroovyTask gtask1 = new GroovyTask(name:'name', priority:1,
            startDate: gtask.startDate, endDate: gtask.endDate)
        GroovyTask gtask2 = new GroovyTask('name', 1, 
            gtask.startDate, gtask.endDate)
        Set tasks = [gtask, gtask1, gtask2]
        
        expect:
        tasks.size() == 1
    }
}
