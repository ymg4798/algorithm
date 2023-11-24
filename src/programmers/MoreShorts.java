package programmers;

import java.util.*;

public class MoreShorts {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        for (int i = 1; i < scoville.length; i++) {
            int temp = scoville[i];

            int j = i - 1;
            while (j >= 0 && scoville[j] > temp) {
                scoville[j + 1] = scoville[j];
                j--;
            }
            scoville[j + 1] = temp;
        }

        if (K <= scoville[0]) {
            return -1;
        }

        int idx = 0;
        int first = 0;
        int second = 0;
        Queue<Integer> newScovilleq = new LinkedList<>();
        newScovilleq.offer(scoville[idx++] + scoville[idx++] * 2);

        while (scoville.length != idx) {
            if(!newScovilleq.isEmpty() && newScovilleq.peek() >= K && scoville[idx] >= K) break;

            first = (newScovilleq.peek() < scoville[idx]) ? newScovilleq.poll() : scoville[idx++];
            second = (newScovilleq.peek() < scoville[idx]) ? newScovilleq.poll() * 2 : scoville[idx++] * 2;

            newScovilleq.offer(first + second);

            answer++;
        }

        return answer;
    }
}

