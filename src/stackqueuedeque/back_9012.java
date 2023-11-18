package stackqueuedeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class back_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] arr = br.readLine().split("");

            Stack<String> stack = new Stack<>();
            for (int j = 0; j < arr.length; j++) {
                String value = arr[j];

                if (value.equals("(")) {
                    stack.push(value);
                } else if (!stack.isEmpty() && stack.peek().equals("(")){
                    stack.pop();
                } else {
                    stack.push(")");
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
