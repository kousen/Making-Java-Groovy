package mjg

import grails.test.mixin.*
import org.junit.*

@TestFor(Order)
class OrderTests {
<<<<<<< HEAD

    void testPrice() {
        OrderLine ol1 = new OrderLine(
           product:new Product(name:'n1', price:2.0), quantity:2)
        OrderLine ol2 = new OrderLine(
           product:new Product(name:'n2', price:3.5), quantity:1)
        Order order = new Order()
            .addToOrderLines(ol1)
            .addToOrderLines(ol2)
        assert 7.5 == order.price
=======
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
>>>>>>> rest
    }
}
