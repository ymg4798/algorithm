package programmers.java.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumValue {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> descpq = new PriorityQueue<>();
        PriorityQueue<Integer> ascpq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            descpq.offer(A[i]);
            ascpq.offer(B[i]);
        }

        while (!descpq.isEmpty()) {
            answer += descpq.poll() * ascpq.poll();
        }

        return answer;
    }
}