package mjg

class OrderLine {
    Product product
    int quantity

    double getPrice() { quantity * product.price }

    String toString() { "$quantity $product @ $product.price = $price" }

    static constraints = {
        quantity min: 0
    }
}
