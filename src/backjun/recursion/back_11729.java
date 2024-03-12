package backjun.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_11729 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = (int) (Math.pow(2, n) - 1);

        hanoi(n, 1, 2, 3);

        System.out.println(count);
        System.out.print(sb);
    }

    public static void hanoi(int n, int start, int mid, int end) {
        if (n == 0) return;

        hanoi(n - 1, start, end, mid);
        sb.append(start).append(" ").append(end).append('\n');
        hanoi(n - 1, mid, start, end);
    }
}
