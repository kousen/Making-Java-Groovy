package mjg.dev

class GroovyUtilityMethods implements UtililyMethods {

    @Override
    int[] getPositives(int[] values) {
        values.findAll { it > 0 }
    }

    @Override
    boolean isPrime(int x) {
        if (x < 0) throw new IllegalArgumentException('argument must be > 0')
        if (x == 2) return true
        for (int i = 2; i < Math.sqrt(x) + 1; i++) {
            if (x % i == 0) return false
        }
        return true
    }
    
    @Override
    boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll(/[ ,']/,'')
        return str.reverse() == str
    }

}
