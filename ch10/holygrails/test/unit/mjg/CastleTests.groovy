package mjg

import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Castle)
class CastleTests {
    Castle castle

    void testValid() {
       castle = new Castle(name:'Camelot',city:'Marlborough',state:'CT')
       mockForConstraintsTests(Castle, [castle])
       assertTrue castle.validate()
    }
}
