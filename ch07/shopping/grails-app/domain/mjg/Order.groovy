package mjg

import java.text.NumberFormat

class Order {
    String number
<<<<<<< HEAD
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [orderLines:OrderLine]
    static belongsTo = [customer:Customer]
    
    double getPrice() {
        orderLines*.price.sum()
    }
    
=======

    static hasMany = [orderLines:OrderLine]
    static belongsTo = [customer:Customer]

    double getPrice() {
        orderLines*.price.sum()
    }

>>>>>>> rest
    String toString() {
        NumberFormat nf = NumberFormat.currencyInstance
        "#$number: ${orderLines.size()} lines, total cost ${nf.format(price)}"
    }
<<<<<<< HEAD
    
=======

>>>>>>> rest
    static mapping = {
        table 'orders'
        orderLines fetch: 'join'
    }

    static constraints = {
    }
}
