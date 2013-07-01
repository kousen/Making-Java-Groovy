package mjg;

import org.junit.Test;

public class CurrencyCategoryTest {
    @Test
    void testCurrencyCategory() {
        use(CurrencyCategory) {
            def amount = 1234567.89012
            if (Locale.default == Locale.US) {
                assert amount.asCurrency() == '$1,234,567.89'
            }
            assert amount.asCurrency(Locale.GERMANY) == "1.234.567,89 \u20ac"
            assert amount.asCurrency(new Locale('hin','IN')) == 'INR 1,234,567.89'
        }
    }
    
    @Test
    void testAnnotatedCurrencyCategory() {
        Number.mixin AnnotationCurrencyCategory
        def amount = 1234567.89012
        if (Locale.default == Locale.US) {
            assert amount.asCurrency() == '$1,234,567.89'
        }
        assert amount.asCurrency(Locale.GERMANY) == "1.234.567,89 \u20ac"
        assert amount.asCurrency(new Locale('hin','IN')) == 'INR 1,234,567.89'
    }
}
