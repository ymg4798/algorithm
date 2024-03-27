package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int result = calculate(dp, n);
        System.out.println(result);
    }

    public static int calculate(int[] dp, int number) {
        if (number == 1) {
            return 0;
        }

        if (dp[number] != -1) {
            return dp[number];
        }

        int minCount = Integer.MAX_VALUE;

        if (number % 2 == 0) {
            minCount = Math.min(minCount, calculate(dp, number / 2) + 1);
        }

        if (number % 3 == 0) {
            minCount = Math.min(minCount, calculate(dp, number / 3) + 1);
        }

        minCount = Math.min(minCount, calculate(dp, number - 1) + 1);

        dp[number] = minCount;

        return minCount;
    }
}
