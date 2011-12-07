package mjg.immutable;

import mjg.ast.immutable.ImmutableLine
import mjg.ast.immutable.ImmutablePoint
import spock.lang.Specification

class ImmutableLineTest extends Specification {
    ImmutableLine line
    
    def setup() {
        ImmutablePoint p1 = new ImmutablePoint(x:3,y:0)
        ImmutablePoint p2 = new ImmutablePoint(x:0,y:4)
        line = new ImmutableLine(start:p1,end:p2)
    }
    
    def "points should be set properly"() {
        expect:
        line.start.x == 3
        line.start.y == 0
        line.end.x == 0
        line.end.y == 4
        Math.abs(line.length - 5) < 0.0001 
    }
    
    def "can't change start"() {
        when: line.start = new ImmutablePoint(x:1,y:1)
        then: thrown(ReadOnlyPropertyException)
    }

    def "can't change end"() {
        when: line.end = new ImmutablePoint(x:1,y:1)
        then: thrown(ReadOnlyPropertyException)
    }

}
