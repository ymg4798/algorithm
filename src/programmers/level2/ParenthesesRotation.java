package programmers.level2;

import java.util.Stack;

public class ParenthesesRotation {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt((i + j) % s.length());

                if (j == 0 && (c == ']' || c == '}' || c == ')')) {
                    stack.push(c);
                    break;
                }

                if (c == '[' || c == '{' || c == '(') {
                    stack.push(c);
                } else if (!stack.isEmpty()) {
                    if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty()) answer++;
        }

        return answer;
    }
}
