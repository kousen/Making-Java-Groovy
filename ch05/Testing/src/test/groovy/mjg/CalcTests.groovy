package mjg;

class CalcTests extends GroovyShellTestCase {
    
    void testAddition() {
        def result = withBinding( [x:3,y:4] ) {
            shell.evaluate(new File('src/main/groovy/mjg/calc.groovy'))
            shell.context.z
        }
        assertEquals 7, result
    }
}
