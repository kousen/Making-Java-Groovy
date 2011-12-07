package mjg;

class ScriptShellTests extends GroovyShellTestCase {
    String base = 'src/main/groovy'

    void testChuckNorris() {
        shell.evaluate(new File("$base/mjg/chuck_norris.groovy"))
    }
    
    void testHelloWorld() {
        def content = new StringWriter()
        withBinding([out:new PrintWriter(content)]) {
            shell.evaluate(new File("$base/mjg/hello_world.groovy"))
            assertEquals "Hello, World!", content.toString().trim()
        } 
    }

    void testHelloName() {
        def content = new StringWriter()
        withBinding([out:new PrintWriter(content), name:'Dolly']) {
            shell.evaluate(new File("$base/mjg/hello_name.groovy"))
            assertEquals "Hello, Dolly!", content.toString().trim()
        } 
    }
}
