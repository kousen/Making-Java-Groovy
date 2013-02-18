package mjg

import grails.test.mixin.*
import org.junit.*

@TestFor(Order)
class OrderTests {
    Order order
    Product p0 = new Product(name: 'p0', price: 2.5)
    Product p1 = new Product(name: 'p1', price: 3)
    Customer c = new Customer(name: 'c')

    @Before
    void setUp() {
        mockForConstraintsTests(Order)
        order = new Order(customer: c, number: 1)
                .addToOrderLines(new OrderLine(quantity: 2, product: p0))
                .addToOrderLines(new OrderLine(quantity: 1, product: p1))
    }

    void testPrice() {
        assert 8 == order.price
    }

    void testValid() {
        assert order.validate()
    }
}
