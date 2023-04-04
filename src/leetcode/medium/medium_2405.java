package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class medium_2405 {
    public int partitionString(String s) {
        int result = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                result++;
                set.clear();
                set.add(s.charAt(i));
            }
        }
        return result;
    }

}
