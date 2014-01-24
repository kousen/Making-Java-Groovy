import mjg.*

class BootStrap {

    def init = { servletContext ->
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

    def destroy = {
    }
}
