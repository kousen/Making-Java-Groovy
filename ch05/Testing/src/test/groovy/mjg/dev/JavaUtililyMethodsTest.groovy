package mjg.dev;

import groovy.util.GroovyTestCase;

class JavaUtililyMethodsTest extends GroovyTestCase {
    UtililyMethods impl = new JavaUtilityMethods()

    void testGetPositives() {
        // log.info('inside testMaxValue')
        def correct = [1,2,3] as int[]
        assertEquals(correct, impl.getPositives((-3..3) as int[]))
    }

    void testIsPrime() {
        def primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
        primes.each { num ->
            assert impl.isPrime(num)
        }
        assert !impl.isPrime(9)
    }

    void testIsPrimeWithNegative() {
        try {
            impl.isPrime(-3)
            fail()
        } catch (IllegalArgumentException e) {
        }
    }

        void testIsPalindrome() {
        assert impl.isPalindrome("Madam, in Eden, I'm Adam")
        assert impl.isPalindrome('Sex at noon taxes')
        assert impl.isPalindrome('Flee to me, remote elf')
        assert !impl.isPalindrome('This is not a palindrome')
    }

}
