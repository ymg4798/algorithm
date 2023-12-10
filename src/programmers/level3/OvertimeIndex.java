package programmers.level3;

import java.util.*;

public class OvertimeIndex {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.offer(work);
        }

        while (n > 0 && !pq.isEmpty()) {
            int uWork = pq.poll() - 1;
            if (uWork > 0) {
                pq.offer(uWork);
            }
            n--;
        }

        for (int work : pq) {
            answer += (long) work * work;
        }

        return answer;
    }
}
