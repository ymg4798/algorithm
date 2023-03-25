package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//다시보기.... 모든답에서 1000000000 가 넘어가는 경우가 있다..
public class back_10844 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long dp[][] = new long[N+1][11];

        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1 ;
        }

        for(int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][1];
            for(int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }

        long result = 0;
        for(int i = 0; i <= 9; i++) {
            result += dp[N][i];
        }
        System.out.println(result%1000000000);
    }
}
