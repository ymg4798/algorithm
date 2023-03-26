package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class leet_13 {
    public static void main(String[] args) {
        System.out.println();
    }

    public int romanToInt(String s) {
        Map<String, Integer> roman = getRoman();
        int result = 0;
        String[] sArray = s.split("");
        for(int i = 0; i < sArray.length; i++) {
            result += roman.get("t");
        }
        return result;
    }

    private Map<String, Integer> getRoman(){
        Map<String, Integer> result = new HashMap<>();
        result.put("I", 1);
        result.put("V", 5);
        result.put("X", 10);
        result.put("L", 50);
        result.put("C", 100);
        result.put("D", 500);
        result.put("M", 1000);
        return result;
    }
}
