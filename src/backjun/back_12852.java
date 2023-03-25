package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_12852 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[n+1];
        int back[] = new int[n+1];
        String result = "";

        dp[n] = 0;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + 1;
            back[i] = i-1;

            if(i%3 == 0 && dp[i/3]+1 < dp[i]) {
                dp[i] = dp[i/3] + 1;
                back[i] = i/3;
            }
            if(i%2 == 0 && dp[i/2]+1 < dp[i]) {
                dp[i] = dp[i/2] + 1;
                back[i] = i/2;
            }
        }

        System.out.println(dp[n]);
        while(n > 0){
            result += n + " ";
            n = back[n];
        }
        System.out.println(result);
    }
}
