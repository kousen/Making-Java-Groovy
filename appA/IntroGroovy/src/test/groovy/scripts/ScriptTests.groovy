package scripts;

class ScriptTests extends GroovyTestCase {
	String baseDir = 'src/main/groovy/'
	GroovyShell shell = new GroovyShell()

	void testClosures() {
		shell.evaluate(new File("$baseDir/closures/closures.groovy"))
	}
	
	void testCollections() {
		shell.evaluate(new File("$baseDir/collections/lists.groovy"))
		shell.evaluate(new File("$baseDir/collections/maps.groovy"))
		shell.evaluate(new File("$baseDir/collections/ranges.groovy"))
	}

	void testConditionals() {
		shell.evaluate(new File("$baseDir/conditionals/conditionals.groovy"))
		shell.evaluate(new File("$baseDir/conditionals/loops.groovy"))
	}
	
	void testNumbers() {
		shell.evaluate(new File("$baseDir/intro/numbers.groovy"))
	}
	
	void testIo() {
		shell.evaluate(new File("$baseDir/io/files.groovy"))
	}
    
	void testOop() {
		shell.evaluate(new File("$baseDir/oop/defaultctor.groovy"))
		shell.evaluate(new File("$baseDir/oop/fieldaccess.groovy"))
		shell.evaluate(new File("$baseDir/oop/givenctor.groovy"))
	}
    
    void testDb() {
        shell.evaluate(new File("$baseDir/db/products.groovy"))
    }
	
	void testStrings() {
		shell.evaluate(new File("$baseDir/groovystrings/strings.groovy"))
	}

    void testMetaprogramming() {
        shell.evaluate(new File("$baseDir/metaprogramming/print_currency.groovy"))
    }
    	
	void testXml() {
		shell.evaluate(new File("$baseDir/xml/parsing.groovy"))
		shell.evaluate(new File("$baseDir/xml/namespaces.groovy"))
	}

}
