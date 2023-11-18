package stackqueuedeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int order = 1;
        while(!queue.isEmpty()) {
            if (queue.peek() == order) {
                queue.poll();
                order++;
            } else if (!stack.isEmpty() && stack.peek() == order) {
                stack.pop();
                order++;
            } else {
                stack.push(queue.poll());
            }
        }

        String result = "Nice";
        while(!stack.isEmpty()) {
            Integer sValue = stack.pop();

            if(sValue != order) {
                result = "Sad";
                break;
            }
            order++;
        }

        System.out.println(result);
    }
}
