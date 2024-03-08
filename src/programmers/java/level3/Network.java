package programmers.java.level3;

import java.util.*;

public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                continue;
            }

            q.offer(i);
            visit[i] = true;

            while (!q.isEmpty()) {
                int poll = q.poll();

                for (int j = 0; j < n; j++) {
                    if (computers[poll][j] == 1 && !visit[j]) {
                        q.offer(j);
                        visit[j] = true;
                    }
                }
            }
            answer++;
        }

        return answer;
    }
}
