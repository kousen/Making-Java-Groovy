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

import org.junit.Test;

class HelloGroovletShellTest extends GroovyShellTestCase {
    String groovlet = 'src/main/webapp/hello.groovy'
    StringWriter content = new StringWriter()
    def capturedOut = new PrintWriter(content)
    
    @Test
    void testGroovletWithNoName() {
        withBinding([out: capturedOut, params:[:]]) {
            shell.evaluate(new File("$groovlet"))
        }
        assert 'Hello, World!' == content.toString().trim()
    }
    
    @Test
    void testGroovletWithName() {
        withBinding([out: capturedOut, params:[name:'Dolly']]) {
            shell.evaluate(new File("$groovlet"))
        }
        assert 'Hello, Dolly!' == content.toString().trim()
    }
}
