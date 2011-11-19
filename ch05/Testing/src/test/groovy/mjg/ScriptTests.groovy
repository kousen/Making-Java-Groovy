package mjg;

import static org.junit.Assert.*;

import org.junit.Test;

class ScriptTests {
    String base = 'src/main/groovy'

    @Test
    void testChuckNorris() {
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
        assertEquals "Hello, World!", content.toString().trim() 
    }

    @Test
    void testHelloName() {
        Binding binding = new Binding()
        binding.name = 'Dolly'
        def content = new StringWriter()
        binding.out = new PrintWriter(content)
        GroovyShell shell = new GroovyShell(binding)
        shell.evaluate(new File("$base/mjg/hello_name.groovy"))
        assertEquals "Hello, Dolly!", content.toString().trim() 
    }
}
