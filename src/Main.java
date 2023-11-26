import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {
        class Solution {
            public int solution(int n) {
                long[] dp = new long[100001];

                dp[1] = 1;
                for (int i = 2; i <= n; i++) {
                    dp[i] = dp[i-1] + dp[i-2];
                }

                return (int) (dp[n] % 1234567L);
            }
        }
}