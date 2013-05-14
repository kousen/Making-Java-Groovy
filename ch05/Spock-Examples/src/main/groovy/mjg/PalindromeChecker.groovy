package mjg

class PalindromeChecker {
    boolean isPalindrome(String s) {
        String testString = s.replaceAll(/\W/,'').toLowerCase()
        return testString.reverse() == testString
    }
}
