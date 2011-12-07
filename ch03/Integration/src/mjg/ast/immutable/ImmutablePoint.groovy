package mjg.ast.immutable

import groovy.transform.Immutable;

@Immutable
class ImmutablePoint {
	double x
	double y
    
    String toString() { "($x,$y)" }
}
