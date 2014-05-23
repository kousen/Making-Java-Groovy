package mjg

import spock.lang.Specification;
import spock.lang.Unroll;

class PalindromeCheckerSpec extends Specification {
    PalindromeChecker checker = new PalindromeChecker()

    def palindromes = [
        'racecar',
        'Sex at noon taxes',
        'Do geese see God?',
        'Flee to me, remote elf!',
        "Madam, in Eden, I'm Adam",
        "Go hang a salami; I'm a lasagna hog!"
    ]

    def "all the listed strings are palindromes"() {
//        		given: "a string that isn't a palindrome"
//        		palindromes << 'this is NOT a palindrome'

        expect:
        palindromes.every { str -> checker.isPalindrome(str) }
//        palindromes.each { str ->
//            assert checker.isPalindrome(str)
//        }
    }

    def "this is not a palindrome"() {
        expect:
        !checker.isPalindrome('this is NOT a palindrome')
    }

}
