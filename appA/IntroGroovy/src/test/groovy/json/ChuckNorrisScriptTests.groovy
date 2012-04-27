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
