package programmers.level2;

public class RepeatBinary {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    count++;
                }
            }

            s = Integer.toBinaryString(s.length() - count);

            answer[0]++;
            answer[1] += count;
        }

        return answer;
    }
}
