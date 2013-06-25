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
package mjg;

import static org.junit.Assert.*;

import org.junit.Test;

class ScriptTests {
    String base = 'src/main/groovy'

    @Test
    void testChuckNorrisScript() {
        GroovyShell shell = new GroovyShell()
        shell.evaluate(new File("$base/mjg/chuck_norris.groovy"))
    }
    
    @Test
    void testHelloWorld() {
        Binding binding = new Binding()
        GroovyShell shell = new GroovyShell(binding)
        def content = new StringWriter()
        binding.out = new PrintWriter(content)
        shell.evaluate(new File("$base/mjg/hello_world.groovy"))
        assert "Hello, World!" == content.toString().trim() 
    }

    @Test
    void testHelloName() {
        Binding binding = new Binding()
        binding.name = 'Dolly'
        def content = new StringWriter()
        binding.out = new PrintWriter(content)
        GroovyShell shell = new GroovyShell(binding)
        shell.evaluate(new File("$base/mjg/hello_name.groovy"))
        assert "Hello, Dolly!" == content.toString().trim() 
    }
}
