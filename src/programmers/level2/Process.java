package programmers.level2;

import java.util.*;

public class Process {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Task> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Task(priorities[i], i));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int priority : priorities) {
            pq.offer(priority);
        }

        while (!q.isEmpty()) {
            Task task = q.poll();

            if (pq.peek() > task.process) {
                q.offer(task);
            } else {
                answer++;
                pq.poll();
                if (task.location == location) break;
            }
        }

        return answer;
    }

    class Task {
        int process;
        int location;

        public Task(int process, int location) {
            this.process = process;
            this.location = location;
        }
    }
}
