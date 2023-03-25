package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());
            long dp[][] = new long[n+1][10];

            for(int i = 0; i <= 9; i++) {
                dp[1][i] = 1;
            }
            for(int i = 2; i <= n; i++) {
                long sum = 0;
                for(int j = 0; j <= 9; j++) {
                    dp[i][j] = dp[i-1][j] + sum;
                    sum += dp[i-1][j];
                }
            }
            long result = 0;
            for(int i = 0; i <= 9; i++) {
                result += dp[n][i];
            }
            System.out.println(result);
        }
    }
}

