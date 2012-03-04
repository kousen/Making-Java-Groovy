package mjg

import grails.test.mixin.TestFor
import org.junit.Before

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Quest)
class QuestTests {
    Quest quest
    
    @Before
    void setUp() {
        quest = new Quest(name:'name')
        mockForConstraintsTests(Quest, [quest])
    }

    void testValid() {
       assertTrue quest.validate()
    }
    
    void testBlankName() {
        quest.name = ''
        assertFalse quest.validate()
        assertEquals 'blank', quest.errors['name']
    }
}
