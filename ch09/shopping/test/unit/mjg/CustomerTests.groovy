package mjg

import grails.test.mixin.*
import org.junit.*

@TestFor(Customer)
class CustomerTests {
    Customer customer = new Customer(name: 'name')

    @Before
    void setUp() {
        mockForConstraintsTests(Customer)
    }

    void testValid() {
       assert customer.validate()
    }

    void testBlankName() {
        customer.name = ' '
        assert !customer.validate()
        assert 'blank' == customer.errors['name']
    }
}
