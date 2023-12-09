package programmers.level2;

import java.util.LinkedList;
import java.util.List;

public class ArraySlice {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        int idx = 0;
        for (long i = left / n; i <= right / n; i++) {
            for (long j = 0; j < n; j++) {
                long value = i * n + j;

                if (left <= value && right >= value) {
                    answer[idx++] = Math.max((int) i, (int) j) + 1;
                }
            }
        }
        return answer;
    }
}
