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
package metaprogramming;

import metaprogramming.without_custom_levels
import metaprogramming.use_slang_category
import metaprogramming.use_emc

import java.util.logging.Level;
import java.util.logging.Logger;

class LoggingTests extends GroovyLogTestCase {
    String baseDir = 'src/main/groovy/metaprogramming'
    
    void testWithoutCustomLevel() {
        def result = stringLog(Level.INFO, without_custom_levels.class.name) {
            GroovyShell shell = new GroovyShell()
            shell.evaluate(new File("$baseDir/without_custom_levels.groovy"))
        }
        assert result.contains('INFO: for your information')
        assert result.contains('SEVERE: oh my goodness')
    }
    
    void testSlangCategory() {
        def result = stringLog(Level.INFO, use_slang_category.class.name) {
            GroovyShell shell = new GroovyShell()
            shell.evaluate(new File("$baseDir/use_slang_category.groovy"))
        }
        assert result.contains('FYI: this seems okay')
        assert result.contains('LOL: snicker')
    }

    void testEMC() {
        def result = stringLog(Level.INFO, use_emc.class.name) {
            GroovyShell shell = new GroovyShell()
            shell.evaluate(new File("$baseDir/use_emc.groovy"))
        }
        assert result.contains('WTF: no effin way')
        assert result.contains('WHOA: dude, seriously')
        assert result.contains("ROFL: you're kidding, right?")
    }

}
