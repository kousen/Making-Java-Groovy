package mjg

class ImmutablePointTests extends GroovyTestCase {
    Point p = new Point(x:3,y:4)
    
    void testInitializationWorked() {
        assert p.x == 3
        assert p.y == 4
    }
    
    void testCantChangeX() {
        shouldFail(ReadOnlyPropertyException) {
            p.x = 99
        }
    }

    void testCantChangeY() {
        shouldFail(ReadOnlyPropertyException) {
            p.y = 99
        }
    }
}

@groovy.transform.Immutable
class Point {
    double x
    double y
}