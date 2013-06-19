package mjg

class Customer {
    String name
<<<<<<< HEAD
    
    String toString() { name }
    
    static hasMany = [orders:Order]

    static constraints = {
        name blank:false
=======

    String toString() { name }

    static hasMany = [orders:Order]

    static constraints = {
        name blank: false
>>>>>>> rest
    }
}
