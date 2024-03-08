package programmers.java.level2;

import java.util.*;

public class Costume {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        for (String key : map.keySet()) {
            int value = map.get(key);
            answer = answer * (value + 1) + value;
        }

        return answer;
    }
}
