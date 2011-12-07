package mjg.immutable;

import mjg.ast.immutable.ImmutableLine
import mjg.ast.immutable.ImmutablePath
import mjg.ast.immutable.ImmutablePoint
import spock.lang.Specification

class ImmutablePathTest extends Specification {
    ImmutablePath path
    
    def setup() {
        def lines = []
        ImmutablePoint p1 = new ImmutablePoint(x:0,y:0)
        ImmutablePoint p2 = new ImmutablePoint(x:3,y:0)
        ImmutablePoint p3 = new ImmutablePoint(x:0,y:4)
        lines << new ImmutableLine(start:p1,end:p2)
        lines << new ImmutableLine(start:p2,end:p3)
        lines << new ImmutableLine(start:p3,end:p1)
        
        path = new ImmutablePath(segments:lines)
    }    

    def "points should be set through ctor"() {
        println path.segments.class.name
        
        expect:
        path.segments.collect { line -> line.start.x } == [0,3,0]
        path.segments.collect { line -> line.start.y } == [0,0,4]
        path.segments.collect { line -> line.end.x } == [3,0,0]
        path.segments.collect { line -> line.end.y } == [0,4,0]
    }
    
    def "cant add new segments"() {
        given:
        ImmutablePoint a = new ImmutablePoint(x:5,y:5)
        ImmutablePoint b = new ImmutablePoint(x:4,y:4)
        
        when:
        path.segments << new ImmutableLine(start:a,end:b)
        
        then:
        thrown UnsupportedOperationException
    }
}
