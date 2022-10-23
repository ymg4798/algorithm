import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2302 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int start = 0;
        int result = 1;
        for(int i = 0; i < m; i++) {
            int sit = Integer.parseInt(br.readLine());
            result = result * dp[sit - start -1];
            start = sit;
        }
        result = result * dp[n - start];
        System.out.println(result);
    }
}
