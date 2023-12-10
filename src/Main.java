import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {
    }

    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<Task> q = new LinkedList<>();

            for (int i = 0; i < priorities.length; i++) {
                q.offer(new Task(priorities[i], i));
            }

            while(!q.isEmpty()) {
                Task poll = q.poll();

                if (poll.location == location) break;

                for (Task task : q) {
                    if (task.process > poll.process) {
                        q.offer(poll);
                        continue;
                    }
                }

                answer++;
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
}