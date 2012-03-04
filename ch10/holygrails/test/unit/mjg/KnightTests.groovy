package mjg

import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Knight)
class KnightTests {
    Knight knight

    void testValid() {
        knight = new Knight(name:'Robin')
        mockForConstraintsTests(Knight, [knight])
    }
}
