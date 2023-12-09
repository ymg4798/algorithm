package programmers.level2;

import java.util.*;

public class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Task> q = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            q.offer(new Task(progresses[i], speeds[i]));
        }

        while (!q.isEmpty()) {
            for (Task task : q) {
                task.update();
            }

            int count = 0;
            while (!q.isEmpty() && q.peek().progress >= 100) {
                q.poll();
                count++;
            }

            if (count > 0) {
                result.add(count);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    class Task {
        int progress;
        int speed;

        public Task(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public void update() {
            progress += speed;
        }
    }
}
