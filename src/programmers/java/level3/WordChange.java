package programmers.java.level3;

import java.util.*;

public class WordChange {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        int[] visit = new int[words.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            if (visit[i] == 0 && isCheck(begin, words[i])) {
                q.offer(i);
                visit[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            Integer idx = q.poll();
            String word = words[idx];

            if (word.equals(target)) return visit[idx];

            for (int i = 0; i < words.length; i++) {
                if (visit[i] == 0 && isCheck(word, words[i])) {
                    q.offer(i);
                    visit[i] = visit[idx] + 1;
                }
            }
        }

        return answer;
    }

    public boolean isCheck(String begin, String next) {
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != next.charAt(i) && ++count > 1) return false;
        }
        return true;
    }
}
