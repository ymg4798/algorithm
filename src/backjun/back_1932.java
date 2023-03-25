package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1932 {
    private static int arr[][];
    private static Integer dp[][];
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new Integer[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            dp[n-1][i] = arr[n-1][i];
        }
        System.out.println(find(0, 0));
    }

    private static int find(int depth, int index) {
        if(depth == n-1) return dp[depth][index];
        if(dp[depth][index] == null) {
            dp[depth][index] = Math.max(find(depth+1,index), find(depth+1,index+1)) + arr[depth][index];
        }
        return dp[depth][index];
    }
}
