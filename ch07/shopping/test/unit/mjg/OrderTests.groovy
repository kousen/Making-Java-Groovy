package mjg

import grails.test.mixin.*
import org.junit.*

@TestFor(Order)
class OrderTests {

    void testPrice() {
        OrderLine ol1 = new OrderLine(
           product:new Product(name:'n1', price:2.0), quantity:2)
        OrderLine ol2 = new OrderLine(
           product:new Product(name:'n2', price:3.5), quantity:1)
        Order order = new Order()
            .addToOrderLines(ol1)
            .addToOrderLines(ol2)
        assert 7.5 == order.price
    }
}
