package metaprogramming

import java.text.NumberFormat;

class CurrencyCategory {
	static String asCurrency(Number amount) {
		NumberFormat.currencyInstance.format(amount)
	}
	
	static String asCurrency(Number amount, Locale loc) {
		NumberFormat.getCurrencyInstance(loc).format(amount)	
	}
}

use(CurrencyCategory) {
	def amount = 1234567.890123
	println amount.asCurrency()
	println amount.asCurrency(Locale.FRANCE)
	println amount.asCurrency(new Locale('hin','IN'))
	println amount.asCurrency(new Locale('da','DK'))
}