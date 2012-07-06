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
package mjg.scripting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExecuteGroovyFromJSR223 {
    private static Logger log = Logger.getLogger(ExecuteGroovyFromJSR223.class.getName());
    
    public static void main(String[] args) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
        try {
            engine.eval("println 'Hello, Groovy!'");
            engine.eval(new FileReader("src/hello_groovy.groovy"));
            
            engine.put("street","Blackheath Avenue");
            engine.put("city","Greenwich");
            engine.put("state","UK");
            engine.eval(new FileReader("src/geocode.groovy"));
            double latitude = Double.parseDouble((String) engine.get("lat"));
            double longitude = Double.parseDouble((String) engine.get("lng"));
            log.info("latitude = " + latitude);
            log.info("longitude = " + longitude);
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
