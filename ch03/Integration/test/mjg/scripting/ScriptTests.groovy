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
