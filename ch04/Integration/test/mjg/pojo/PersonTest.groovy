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
package mjg.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

class PersonTest {
    Person p
    
    @Test
    public void testPerson() {
        p = new Person()
        assert !p.id
        assert !p.name
    }

    @Test
    public void testPersonIntString() {
        p = new Person(1,'Buffy')
        assert 1 == p.id
        assert 'Buffy' == p.name
    }

    @Test
    public void testGetId() {
        p = new Person(id:99)
        assert 99 == p.id
    }

    @Test
    public void testGetName() {
        p = new Person(id:86,name:'Maxwell Smart')
        assert 86 == p.id
        assert 'Maxwell Smart' == p.name
    }
}
