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
package mjg.scripting

import static org.junit.Assert.*
import groovy.lang.GroovyShell

import java.io.ByteArrayOutputStream
import java.io.File

import org.junit.After
import org.junit.Before
import org.junit.Test

class ScriptTests {
    GroovyShell shell
    PrintStream orig
    ByteArrayOutputStream out
    
    @Before
    void setUp() {
        orig = System.out
        out = new ByteArrayOutputStream()
        System.setOut(new PrintStream(out))
        shell = new GroovyShell()
    }
    
    @After
    void tearDown() {
        System.setOut(orig)
    }
    
    @Test
    void testHelloGroovy() {
        shell.evaluate(new File('src/mjg/scripting/hello_groovy.groovy'))
        assertEquals 'Hello, Groovy!', out.toString().trim()
    }
    
    @Test
    void testSortListScript() {
        shell.evaluate(new File('src/mjg/sorting/sort_list.groovy'))
    }

    @Test
    void testUsePojoScript() {
        shell.evaluate(new File('src/mjg/pojo/use_pojo.groovy'))
    }
    
}
