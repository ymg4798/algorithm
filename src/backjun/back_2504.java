package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class back_2504 {
    private static int arr[][];
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        String arr[] = br.readLine().split("");
        int result = 0;
        int value = 1;
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("(")) {
                stack.push(arr[i]);
                value *= 2;
            } else if(arr[i].equals("[")) {
                stack.push(arr[i]);
                value *= 3;
            } else if(arr[i].equals(")")) {
                if(stack.isEmpty() || !stack.peek().equals("(")) {
                    result = 0;
                    break;
                } else if(arr[i-1].equals("(")) {
                    result += value;
                }
                stack.pop();
                value /= 2;
            } else if(arr[i].equals("]")) {
                if(stack.isEmpty() || !stack.peek().equals("[")) {
                    result = 0;
                    break;
                } else if(arr[i-1].equals("[")) {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        if(!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }

}

