package mjg

import java.text.NumberFormat

class Order {
    String number

    Date dateCreated
    Date lastUpdated
    
    static hasMany = [orderLines:OrderLine]
    static belongsTo = [customer:Customer]
    
    double getPrice() {
        orderLines*.price.sum()
    }
    
    String toString() {
        NumberFormat nf = NumberFormat.currencyInstance
        "#$number: ${orderLines.size()} lines, total cost ${nf.format(price)}"
    }

    static mapping = {
        table 'orders'
        orderLines fetch: 'join'
    }

    static constraints = {
    }
}
