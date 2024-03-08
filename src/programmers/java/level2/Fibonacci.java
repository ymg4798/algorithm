package programmers.java.level2;

public class Fibonacci {
    public int solution(int n) {
        long[] dp = new long[100001];

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] % 1234567L + dp[i-2] % 1234567L;
        }

        return (int) (dp[n] % 1234567L);
    }
}
