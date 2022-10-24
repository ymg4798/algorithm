import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dp[][] = new int[N+1][10];

        for(int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = j; k <= 9; k++) {
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] = dp[i][j]%10007;
            }
        }

        int result = 0;
        for(int i = 0; i <= 9; i++) {
            result += dp[N][i];
        }
        System.out.println(result%10007);
    }
}

