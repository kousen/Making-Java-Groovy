package mjg.dev;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class GroovyUtilityMethodsJUnit4Tests {
    UtilityMethods impl = new GroovyUtilityMethods()

    @Test
    void testGetPositives() {
        def correct = [1, 2, 3] as int[]
        assert correct == impl.getPositives((-3..3) as int[])
    }

    @Test
    void testIsPrime() {
        def primes = [2, 3, 5, 7, 11, 13, 17, 19, 23]
        primes.each { num ->
            assertTrue impl.isPrime(num)
        }
        assert !impl.isPrime(9)
    }

    @Test(expected=IllegalArgumentException)
    void testIsPrimeWithNegative() {
        impl.isPrime(-3)
    }

    @Test
    void testIsPalindrome() {
        assert impl.isPalindrome("Madam, in Eden, I'm Adam")
        assert impl.isPalindrome('Sex at noon taxes')
        assert impl.isPalindrome('Flee to me, remote elf')
        assert !impl.isPalindrome('This is not a palindrome')
    }
}
