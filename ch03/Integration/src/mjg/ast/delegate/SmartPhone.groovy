package mjg.ast.delegate

import groovy.lang.Delegate;

class SmartPhone {
    @Delegate Camera camera
    @Delegate ContactManager contactManager
    @Delegate Phone phone
}
