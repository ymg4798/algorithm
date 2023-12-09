package programmers.level2;

import java.util.*;

public class DiscountOffer {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> map = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                String value = discount[j];
                map.put(value, map.getOrDefault(value, 0) + 1);
            }

            boolean[] isCheck = new boolean[want.length];
            for (int j = 0; j < want.length; j++) {
                if (map.containsKey(want[j]) && map.get(want[j]) == number[j]) {
                    isCheck[j] = true;
                }
            }

            if (allTrue(isCheck)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean allTrue(boolean[] isArray) {
        for (boolean value : isArray) {
            if(!value) {
                return false;
            }
        }
        return true;
    }
}
