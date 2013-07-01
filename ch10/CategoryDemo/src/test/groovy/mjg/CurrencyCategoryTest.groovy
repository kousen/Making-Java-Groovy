package mjg;

import org.junit.Test;

public class CurrencyCategoryTest {
    public static final String EURO = '\u20ac'
    def amount = 1234567.89012
    
    @Test
    void testCurrencyCategory() {
        use(CurrencyCategory) {
            if (Locale.default == Locale.US) {
                assert amount.asCurrency() == '$1,234,567.89'
            }
            assert amount.asCurrency(Locale.GERMANY) == "1.234.567,89 $EURO"
            assert amount.asCurrency(new Locale('hin','IN')) == 'INR 1,234,567.89'
        }
    }
    
    @Test
    void testAnnotatedCurrencyCategory() {
        Number.mixin AnnotationCurrencyCategory
        if (Locale.default == Locale.US) {
            assert amount.asCurrency() == '$1,234,567.89'
        }
        assert amount.asCurrency(Locale.GERMANY) == "1.234.567,89 $EURO"
        assert amount.asCurrency(new Locale('hin','IN')) == 'INR 1,234,567.89'
    }
}
