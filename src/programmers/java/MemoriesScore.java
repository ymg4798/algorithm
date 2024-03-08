package programmers.java;

import java.util.HashMap;

public class MemoriesScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            String[] valueArray = photo[i];

            int sum = 0;
            for (int j = 0; j < valueArray.length; j++) {
                String value = valueArray[j];

                if (map.containsKey(value)) {
                    Integer point = map.get(value);
                    sum += point;
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}
