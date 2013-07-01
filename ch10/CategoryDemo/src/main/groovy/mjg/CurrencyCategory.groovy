package mjg

import java.text.NumberFormat

class CurrencyCategory {
    static String asCurrency(Number amount) {
        NumberFormat.currencyInstance.format(amount)
    }

    static String asCurrency(Number amount, Locale loc) {
        NumberFormat.getCurrencyInstance(loc).format(amount)
    }
}