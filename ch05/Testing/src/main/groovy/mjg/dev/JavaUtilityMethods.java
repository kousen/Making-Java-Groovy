package mjg.dev;

import java.util.ArrayList;
import java.util.List;

public class JavaUtilityMethods implements UtililyMethods {

    public int[] getPositives(int[] values) {
        List<Integer> results = new ArrayList<Integer>();
        for (Integer i : values) {
            if (i > 0) results.add(i);
        }
        int[] answer = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }

    public boolean isPrime(int x) {
        if (x < 0) throw new IllegalArgumentException("argument must be > 0");
        if (x == 2) return true;
        for (int i = 2; i < Math.sqrt(x) + 1; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        String forward = sb.toString().toLowerCase();
        String backward = sb.reverse().toString().toLowerCase();
        return forward.equals(backward);
    }

}
