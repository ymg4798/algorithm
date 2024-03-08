package programmers.java.level2;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int w = 0;
        int h = 0;

        for (int i = 1; i * i <= yellow; i++) {
            if (yellow % i == 0) {
                w = yellow/i + 2;
                h = i + 2;

                if (w * h == brown + yellow) break;
            }
        }

        int[] answer = new int[] {w,h};
        return answer;
    }
}
