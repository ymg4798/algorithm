package backjun.stackqueuedeque;

import java.io.*;
import java.util.*;

public class back_28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (command == 2) {
                try {
                    bw.append(String.valueOf(stack.pop()));
                } catch (Exception e) {
                    bw.append("-1");
                }
                bw.append("\n");
            } else if (command == 3) {
                bw.append(String.valueOf(stack.size()));
                bw.append("\n");
            } else if (command == 4) {
                if (stack.isEmpty()) {
                    bw.append("1");
                } else {
                    bw.append("0");
                }
                bw.append("\n");
            } else if (command == 5) {
                try {
                    bw.append(String.valueOf(stack.peek()));
                } catch (Exception e) {
                    bw.append("-1");
                }
                bw.append("\n");
            }
        }
        bw.flush();
    }
}
