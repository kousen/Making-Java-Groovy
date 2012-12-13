package mjg

import grails.test.mixin.*
import org.junit.*

@TestFor(OrderLine)
class OrderLineTests {

    void testGetPrice() {
        Product p = new Product(name:'n1', price:2.0)
        OrderLine ol = new OrderLine(product:p, quantity:2)
        assert ol.price == p.price * ol.quantity
    }
}
