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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class HelloGroovletUnitTest {
    String groovlet = 'src/main/webapp/hello.groovy'
    GroovyShell shell
    Binding binding = new Binding()
    StringWriter content = new StringWriter()
    
    @Before
    void setUp() {
        binding.params = [:]
        binding.out = new PrintWriter(content)
        shell = new GroovyShell(binding)
    }
    
    @Test
    void testGroovletWithNoName() {
        shell.evaluate(new File("$groovlet"))
        assert 'Hello, World!' == content.toString().trim()
    }
    
    @Test
    void testGroovletWithName() {
        binding.params = [name:'Dolly']
        shell.evaluate(new File("$groovlet"))
        assert 'Hello, Dolly!' == content.toString().trim()
    }
}
