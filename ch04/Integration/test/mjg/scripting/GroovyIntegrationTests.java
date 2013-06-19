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

import static junit.framework.Assert.assertEquals;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.Eval;

import mjg.scripting.Geocoder;
import mjg.scripting.Location;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.codehaus.groovy.control.CompilationFailedException;
import org.junit.Test;


public class GroovyIntegrationTests {
    @Test
    public void testEvalNoParams() {
        String result = (String) Eval.me("'abc' - 'b'");
        assertEquals("ac",result);
    }
    
    @Test
    public void testEvalOneParam() {
        String result = (String) Eval.x("a", "'abc' - x");
        assertEquals("bc",result);
    }
    
    @Test
    public void testEvalTwoParams() {
        String result = (String) Eval.xy("a", "b", "'abc' - x - y");
        assertEquals("c",result);
    }
    
    @Test
    public void testEvalThreeParams() {
        String result = (String) Eval.xyz("a", "b", "d", "'abc' - x - y + z");
        assertEquals("cd",result);
    }
    
    @Test
    public void testEvaluateString() {
        GroovyShell shell = new GroovyShell();
        Object result = shell.evaluate("3+4");
        assertEquals(7, result);
    }
    
    @Test
    public void testLatLng() {
        Binding binding = new Binding();
        binding.setVariable("street", "1600 Pennsylvania Avenue");
        binding.setVariable("city", "Washington");
        binding.setVariable("state", "DC");
        GroovyShell shell = new GroovyShell(binding);
        try {
            shell.evaluate(new File("src/geocode.groovy"));
            assertEquals(38.898,
                Double.parseDouble((String) binding.getVariable("lat")),0.01);
            assertEquals(-77.037,
                Double.parseDouble((String) binding.getVariable("lng")),0.01);
        } catch (CompilationFailedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testLatLngWithModifiedBinding() {
        Binding binding = new Binding();
        binding.setVariable("street", "1600 Pennsylvania Avenue");
        binding.setVariable("city", "Washington");
        binding.setVariable("state", "DC");
        GroovyShell shell = new GroovyShell(binding);
        try {
            shell.evaluate(new File("src/geocode.groovy"));
            assertEquals(38.898,
                Double.parseDouble((String) binding.getVariable("lat")),0.01);
            assertEquals(-77.037,
                Double.parseDouble((String) binding.getVariable("lng")),0.01);
            
            binding.setVariable("street", "Blackheath Avenue");
            binding.setVariable("city","Greenwich");
            binding.setVariable("state","UK");
            shell.evaluate(new File("src/geocode.groovy"));
            assertEquals(51.476,
                    Double.parseDouble((String) binding.getVariable("lat")),0.01);
                assertEquals(0.001,
                    Double.parseDouble((String) binding.getVariable("lng")),0.01);
                
        } catch (CompilationFailedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testLatLngJSR223() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
        engine.put("street", "Blackheath Avenue");
        engine.put("city","Greenwich");
        engine.put("state", "UK");
        try {
            engine.eval(new FileReader("src/geocode.groovy"));
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(51.4752654,
            Double.parseDouble((String) engine.get("lat")),0.01);
        assertEquals(0.0014342,
            Double.parseDouble((String) engine.get("lng")),0.01);
    }
    
    @Test
    public void testGeocoder() {
        Location loc = new Location();
        loc.setState("1600 Pennsylvania Avenue");
        loc.setCity("Washington");
        loc.setState("DC");
        Geocoder geocoder = new Geocoder();
        geocoder.fillInLatLong(loc);
        assertEquals(38.895,loc.getLatitude(),0.01);
        assertEquals(-77.037,loc.getLongitude(),0.01);
    }
}
