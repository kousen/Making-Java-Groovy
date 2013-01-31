import mjg.*

class BootStrap {

    def init = { servletContext ->
        Customer brown = new Customer(name: 'Charlie Brown').save()
        Product fb = new Product(name: 'football', price: 6).save()
        Product bb = new Product(name: 'baseball', price: 12).save()
        Order order = new Order(number: '1', customer: brown)
            .addToOrderLines(quantity: 2, product: fb)
            .addToOrderLines(quantity: 1, product: bb)
            .save(failOnError: true)
    }

    def destroy = {
    }
}
