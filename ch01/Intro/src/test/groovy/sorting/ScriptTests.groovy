package sorting;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import groovy.lang.GroovyShell;

class ScriptTests {
    
    @Test
    void testSortStrings() {
        GroovyShell shell = new GroovyShell()
        shell.evaluate(new File("src/main/groovy/sorting/sort_strings.groovy"))
    }
}
