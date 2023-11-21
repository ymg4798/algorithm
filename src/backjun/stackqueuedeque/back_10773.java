package backjun.stackqueuedeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class back_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n != 0) {
                stack.push(n);
            } else {
                stack.pop();
            }
        }

        int result = 0;
        if (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                result += stack.pop();
            }
        }
        System.out.println(result);
    }
}
