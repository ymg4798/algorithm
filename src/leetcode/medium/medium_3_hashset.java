package leetcode.medium;

import java.util.HashSet;

class medium_3_hashset {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        String[] arr = s.split("");
        HashSet<String> set = new HashSet<>();

        if (s.equals("")) {
            return 0;
        }

        int result = 1;
        set.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                result = Math.max(result, set.size());
                set.clear();
            }
            set.add(arr[i]);
        }

        return result;
    }
}
