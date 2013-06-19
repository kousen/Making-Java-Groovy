package mjg.scripting

import java.text.NumberFormat

String base = 'http://finance.yahoo.com/d/quotes.csv?'
String symbols = ['GOOG','YHOO','MSFT'].join(',')
String qs = [s:symbols, f:'sl1'].collect { it }.join('&')
def results = "$base$qs".toURL().text.trim()
NumberFormat nf = NumberFormat.currencyInstance
results.eachLine {
    def (symbol, price) = it.split(',')
    println "$symbol last trade at ${nf.format(price.toDouble())}"
}