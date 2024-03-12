package backjun.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_15651 {
    public static int[] arr;
    public static boolean[] visited;
    public static int n, m;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[m];
        visited = new boolean[n];
        sb = new StringBuilder();

        dfs(0);

        System.out.print(sb);
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}
