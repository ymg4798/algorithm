package programmers.level2;

import java.util.*;

public class RemovePair {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();

        for (String value : s.split("")) {
            if (!stack.isEmpty() && stack.peek().equals(value)) {
                stack.pop();
            } else {
                stack.push(value);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
