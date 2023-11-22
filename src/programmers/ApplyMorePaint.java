package programmers;

public class ApplyMorePaint {
    public int solution(int n, int m, int[] section) {
        int answer = 1;

        int range = m;
        for (int i = 1; i < section.length; i++) {
            int sectionRange = section[i] - section[i-1];
            if (sectionRange < range) {
                range -= sectionRange;
            } else {
                range = m;
                answer++;
            }
        }

        return answer;
    }
}
