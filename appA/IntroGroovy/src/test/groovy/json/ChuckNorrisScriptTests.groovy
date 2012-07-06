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
package json;

import static org.junit.Assert.*
import org.junit.Test
import groovy.mock.interceptor.StubFor

class ChuckNorrisScriptTests {
    String base = 'src/main/groovy'

    @Test
    void testChuckNorrisOnline() {
        GroovyShell shell = new GroovyShell()
        shell.evaluate(new File("$base/json/chuck_norris.groovy"))
    }
    
    @Test
    void testChuckNorrisOffline() {
        def result = '''
        {
            "value" : {
                "joke" : "Chuck Norris can make a class abstract AND final"
            }
        }
        '''
   
        StubFor stub = new StubFor(URL)
        stub.demand.getText { result }
        
        stub.use {
            GroovyShell shell = new GroovyShell()
            shell.evaluate(new File("$base/json/chuck_norris.groovy"))
        }
    }    
}
