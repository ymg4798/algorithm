package programmers.level3;

import java.util.*;

public class Compression {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)('A' + i)), i + 1);
        }

        int left = 0;
        int right = 1;
        int addition = 27;
        int length = msg.length();

        while (left < length) {
            String str = msg.substring(left, right);

            if (!map.containsKey(str)) {
                map.put(str, addition++);
                list.add(map.get(msg.substring(left, --right)));
                left = right;
            }

            if (right == length) {
                list.add(map.get(str));
                break;
            }

            right++;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
