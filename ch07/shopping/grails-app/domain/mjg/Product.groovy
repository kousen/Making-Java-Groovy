package mjg

class Product {
    String name
    double price

    String toString() { name }
<<<<<<< HEAD
    
    static constraints = {
        name blank:false
        price min:0.0d
=======

    static constraints = {
        name blank: false
        price min: 0.0d
>>>>>>> rest
    }
}
