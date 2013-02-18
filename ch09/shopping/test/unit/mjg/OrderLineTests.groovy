package mjg

import grails.test.mixin.*
import org.junit.*

@TestFor(OrderLine)
class OrderLineTests {
    OrderLine line

    @Before
    void setUp() {
        mockForConstraintsTests(OrderLine)
        Product p = new Product(name: 'p0', price: 2)
        line = new OrderLine(product: p, quantity: 3)
    }

    void testPrice() {
        assert 3 * 2 == line.price
    }

    void testValid() {
       assert line.validate()
    }

    void testNegQuantity() {
        line.quantity = -1
        assert !line.validate()
        assert 'min' == line.errors['quantity']
    }
}
