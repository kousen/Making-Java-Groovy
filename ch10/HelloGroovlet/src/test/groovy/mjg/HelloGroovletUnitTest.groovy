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
