package mjg.ast.immutable

import groovy.lang.Singleton;

@Singleton
class ImmutablePointFactory {
	ImmutablePoint newImmutablePoint(xval,yval) {
		return new ImmutablePoint(x:xval,y:yval)
	}
    
    // Only to make Eclipse stop saying there's no instance field
    //   when ImmutablePoint.instance called from Java
    static ImmutablePoint newIP(xval,yval) {
        return new ImmutablePoint(x:xval,y:yval)
    }
}
