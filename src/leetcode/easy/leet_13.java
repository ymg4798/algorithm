package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class leet_13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> roman = getRoman();

        int result = 0; int prev = 0; int cur = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            cur = roman.get(s.charAt(i));

            if (cur < prev) {
                result -= cur;
            } else {
                result += cur;
            }
            prev = cur;
        }
        return result;
    }

    private static Map<Character, Integer> getRoman(){
        Map<Character, Integer> result = new HashMap<>();
        result.put('I', 1);
        result.put('V', 5);
        result.put('X', 10);
        result.put('L', 50);
        result.put('C', 100);
        result.put('D', 500);
        result.put('M', 1000);
        return result;
    }
/*
    public int romanToInt(String s) {
        Map<String, Integer> roman = getRoman();
        int result = 0;
        String[] sArray = s.split("");

        String key = sArray[0];
        result = roman.get(key);
        for(int i = 1; i < sArray.length; i++) {
            if (roman.containsKey(key + sArray[i])) {
                result = result - roman.get(key) + roman.get(key + sArray[i]);
            } else {
                result += roman.get(sArray[i]);
            }
            key = sArray[i];
        }

        return result;
    }

    private Map<String, Integer> getRoman(){
        Map<String, Integer> result = new HashMap<>();
        result.put("I", 1);
        result.put("V", 5);
        result.put("X", 10);
        result.put("IV", 4);
        result.put("IX", 9);
        result.put("L", 50);
        result.put("C", 100);
        result.put("XL", 40);
        result.put("XC", 90);
        result.put("D", 500);
        result.put("M", 1000);
        result.put("CD", 400);
        result.put("CM", 900);
        return result;
    }
 */
}
