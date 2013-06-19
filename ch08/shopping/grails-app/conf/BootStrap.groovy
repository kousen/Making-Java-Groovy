import mjg.*

class BootStrap {

    def init = { servletContext ->
<<<<<<< HEAD
        if (!Product.findByName('baseball')) {
            Product baseball = new Product(name:'baseball', price:5.99).save()
            Product football = new Product(name:'football', price:12.99).save()
            Customer cb = new Customer(name:'Charlie Brown').save()
            Order o1 = new Order(number:'1', customer:cb)
                .addToOrderLines(product:baseball, quantity:2)
                .addToOrderLines(product:football, quantity:1)
                .save()
        }
    }
=======
        Customer brown = new Customer(name: 'Charlie Brown').save()
        Product fb = new Product(name: 'football', price: 6).save()
        Product bb = new Product(name: 'baseball', price: 12).save()
        Order order = new Order(number: '1', customer: brown)
            .addToOrderLines(quantity: 2, product: fb)
            .addToOrderLines(quantity: 1, product: bb)
            .save(failOnError: true)
    }

>>>>>>> rest
    def destroy = {
    }
}
