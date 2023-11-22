package programmers;

import java.util.HashMap;

public class MemoriesScore {

    public static void main(String[] args) {
        String[] a = new String[1];


        System.out.println(a[0].equals("a"));
    }
}
    class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            int[] answer = new int[photo.length];

            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < name.length; i++) {
                map.put(name[i], yearning[i]);
            }

            for (int i = 0; i < photo.length; i++) {
                String[] valueArray = photo[i];
            }

            return answer;
        }
}
