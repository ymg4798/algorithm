package programmers.java.level1;

import java.util.*;

public class SamePersonality {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] array = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            int lastIdx = array[idx];

            answer[i] = (lastIdx == 0) ? -1 : i + 1 - lastIdx;
            array[idx] = i + 1;
        }

        return answer;
    }

    public int[] solution2(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            answer[i] = (map.containsKey(c)) ? i - map.get(c) : -1;

            map.put(c, i);
        }

        return answer;
    }
}
