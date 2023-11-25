package programmers.level1;

import java.util.*;

public class CommonNumber {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            }else if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        int idx = stack.size();
        int[] answer = new int[idx];
        while (idx != 0) {
            answer[--idx] = stack.pop();
        }

        return answer;
    }
}
