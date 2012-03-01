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
