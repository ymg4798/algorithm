package programmers.level2;

public class LongJump {
    public long solution(int n) {
        if (n == 1) return 1;

        long[] dp = new long[2000];
        dp[1] = 1L;
        dp[2] = 2L;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1]%1234567 + dp[i - 2]%1234567;
        }

        return dp[n]%1234567;
    }
}
