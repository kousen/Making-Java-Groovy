package mjg

class Product {
    String name
    double price

    String toString() { name }

    static constraints = {
        name blank: false
        price min: 0.0d
    }
}
