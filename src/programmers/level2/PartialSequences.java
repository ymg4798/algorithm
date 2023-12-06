package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class PartialSequences {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = 0; j < elements.length; j++) {
                sum += elements[(i + j) % elements.length];
                set.add(sum);
            }
        }

        return set.size();
    }
}


/*
    public int solution(int[] elements) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for (int i : elements) {
            q.offer(i);
        }

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                int temp = i;
                while(temp >= 0) {
                    int value = q.poll();
                    sum += value;
                    q.offer(value);
                    temp--;
                }
                set.add(sum);
            }
        }

        return set.size();
    }*/
