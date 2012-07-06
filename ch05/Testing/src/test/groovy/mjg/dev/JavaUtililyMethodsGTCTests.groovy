/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
package mjg.dev;

import groovy.util.GroovyTestCase;

class JavaUtililyMethodsGTCTests extends GroovyTestCase {
    UtilityMethods impl = new JavaUtilityMethods()

    void testGetPositives() {
        log.info('inside testGetPositives')
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
        shouldFail(IllegalArgumentException) {
            impl.isPrime(-3)
        }
    }

    void testIsPalindrome() {
        assert impl.isPalindrome("Madam, in Eden, I'm Adam")
        assert impl.isPalindrome('Sex at noon taxes')
        assert impl.isPalindrome('Flee to me, remote elf')
        assert !impl.isPalindrome('This is not a palindrome')
    }

}
