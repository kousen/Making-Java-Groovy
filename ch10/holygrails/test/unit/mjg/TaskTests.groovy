package mjg

import grails.test.mixin.TestFor
import org.junit.Before

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Task)
class TaskTests {
    Task task
    
    @Before
    void setUp() {
        Quest q = new Quest(name:'name')
        task = new Task(name:'task',priority:3,startDate:new Date(),endDate:new Date(),completed:false,quest:q)
        mockForConstraintsTests(Task, [task])
    }

    void testValid() {
       assertTrue task.validate()
    }
    
    void testBlankName() {
        task.name = ''
        assertFalse task.validate()
    }
    
    void testBelowMinPriority() {
        task.priority = 0
        assertFalse task.validate()
    }
    
    void testAboveMaxPriority() {
        task.priority = 6
        assertFalse task.validate()
    }
    
    void testValidPriorities() {
        (1..5).each {
            task.priority = it
            assertTrue task.validate()
        }
    }
    
    void testStartDateAfterEndDate() {
        task.startDate = task.endDate + 1
        assertFalse task.validate()
    }
}
