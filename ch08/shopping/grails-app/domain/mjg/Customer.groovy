package mjg

class Customer {
    String name
    String toString() { name }

    static hasMany = [orders:Order]

    static constraints = {
        name blank: false
    }
}
