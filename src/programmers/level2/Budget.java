package programmers.level2;

import java.util.*;

public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < d.length; i++) {
            pq.offer(d[i]);
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();

            if (num + sum <= budget) {
                sum += num;
                answer++;
            }
        }

        return answer;
    }

    public int solution2(int[] d, int budget) {
        int answer = 0;

        for (int i = 0; i < d.length; i++) {
            int temp = d[i];
            int j = i - 1;

            while (j >= 0 && d[j] > temp) {
                d[j + 1] = d[j];
                j--;
            }
            d[j + 1] = temp;
        }

        for (int i = 0; i < d.length; i++) {
            budget -= d[i];

            if (budget < 0) break;

            answer++;
        }

        return answer;
    }
}
