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

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class JavaUtilityMethodsJUnit3Tests extends TestCase {
    private UtilityMethods impl = new JavaUtilityMethods();

    public void testGetPositives() {
        int[] testValues = {-3, 1, 4, -1, 5, -2, 6};
        List<Integer> testList = new ArrayList<Integer>();
        testList.add(1);  testList.add(4);
        testList.add(5);  testList.add(5);
        testList.add(6);
        int[] results = impl.getPositives(testValues);
        for (int i : results) {
            assertTrue(testList.contains(i));
        }
    }

    public void testIsPrime() {
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);  primes.add(3);
        primes.add(5);  primes.add(7);
        primes.add(11); primes.add(13);
        primes.add(17); primes.add(19);
        primes.add(23); primes.add(29);
        for (Integer p : primes) {
            assertTrue(impl.isPrime(p));
        }
        assertFalse(impl.isPrime(9));
    }

    public void testIsPrimeWithNegative() {
        try {
            impl.isPrime(-3);
            fail();
        } catch (IllegalArgumentException e) {
            // System.out.println("Caught expected exception");
        }
    }

    public void testIsPalindrome() {
        assertTrue(impl.isPalindrome("Madam, in Eden, I'm Adam"));
        assertTrue(impl.isPalindrome("Lisa Bonet ate no basil"));
        assertTrue(impl.isPalindrome("Are we not drawn onward, we few, drawn onward to new era!"));
        assertFalse(impl.isPalindrome("This is not a palindrome"));
    }

}
