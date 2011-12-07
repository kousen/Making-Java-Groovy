package mjg.ast.immutable

import groovy.transform.Immutable;

@Immutable
class ImmutableLine {
    ImmutablePoint start
    ImmutablePoint end
    
    def getLength() {
        double dx = end.x - start.x
        double dy = end.y - start.y
        return Math.sqrt(dx*dx + dy*dy)
    }
    
    String toString() { "from $start to $end" }
}
