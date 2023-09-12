package leetcode.medium;

import java.util.Arrays;

public class medium_5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        String[] arr = s.split("");
        int start_point = 0;
        int end_point = 0;
        int max_length = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (max_length < j - i + 1) {
                    if (check(arr, i, j)) {
                        max_length = j - i + 1;
                        start_point = i;
                        end_point = j + 1;
                    }
                }
            }
        }
        return s.substring(start_point, end_point);
    }

    public static boolean check(String[] arr, int start, int end) {
        while (start < end) {
            if (!arr[start].equals(arr[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
