package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] board = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(board[0]);
            return;
        } else if (n == 2) {
            System.out.println(board[0] + board[1]);
            return;
        }

        dp[0] = board[0];
        dp[1] = dp[0] + board[1];
        dp[2] = Math.max(dp[0] + board[2], board[1] + board[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + board[i], board[i] + board[i - 1] + dp[i - 3]);
        }

        System.out.println(dp[n - 1]);
    }
}
