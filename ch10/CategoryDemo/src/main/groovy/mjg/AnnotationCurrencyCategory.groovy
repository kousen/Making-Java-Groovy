package mjg

import java.text.NumberFormat

@Category(Number)
class AnnotationCurrencyCategory {
    String asCurrency() {
        NumberFormat.currencyInstance.format(this)
    }

    String asCurrency(Locale loc) {
        NumberFormat.getCurrencyInstance(loc).format(this)
    }
}
