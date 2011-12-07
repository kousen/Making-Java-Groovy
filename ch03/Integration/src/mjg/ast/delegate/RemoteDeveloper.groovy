package mjg.ast.delegate

import groovy.lang.Delegate;

class RemoteDeveloper {
	@Delegate
	LocalDeveloper developer
	
	String whereAreYou() {
		return developer.whereAreYou() + " (in another country)"
	}
}
