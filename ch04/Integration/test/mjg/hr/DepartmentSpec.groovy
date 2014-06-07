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
package mjg.hr;

import static org.junit.Assert.*
import spock.lang.Specification

class DepartmentSpec extends Specification {
    Department dept = new Department(name:'IT');

    def "add employee to dept should increase total by 1"() {
        given:
        Employee fred = new Employee(name:'Fred',id:1)
        
        when:
        dept = dept + fred
        
        then:
        dept.employees.size() == old(dept.employees.size()) + 1
    }
    
    def "add two employees via chained plus"() {
        given:
        Employee fred = new Employee(name:'Fred',id:1)
        Employee barney = new Employee(name:'Barney',id:2)
        
        when:
        dept = dept + fred + barney
        
        then:
        dept.employees.size() == 2
    }
    
    def "subtract emp from dept should decrease by 1"() {
        given:
        Employee fred = new Employee(name:'Fred',id:1)
        dept.hire fred
        
        when:
        dept = dept - fred
        
        then:
        dept.employees.size() == old(dept.employees.size()) - 1
    }

    def "remove two employees via chained minus"() {
        given:
        Employee fred = new Employee(name:'Fred',id:1)
        Employee barney = new Employee(name:'Barney',id:2)
        dept.hire fred
        dept.hire barney
        
        when:
        dept = dept - fred - barney
        
        then:
        dept.employees.size() == 0
    }

    def "add employee to dept via left shift should increase total by 1"() {
        given:
        Employee fred = new Employee(name:'Fred',id:1)
        
        when:
        dept = dept << fred
        
        then:
        dept.employees.size() == old(dept.employees.size()) + 1
    }
    
    def "add two employees via chained left shift"() {
        given:
        Employee fred = new Employee(name:'Fred',id:1)
        Employee barney = new Employee(name:'Barney',id:2)
        
        when:
        dept = dept << fred << barney
        
        then:
        dept.employees.size() == 2
    }
    
}
