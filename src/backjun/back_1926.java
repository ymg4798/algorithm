package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1926 {
    public static int move[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static int arr[][];
    public static boolean visit[][];
    public static int n,m;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1 && !visit[i][j]) {
                    count++;
                    max = Math.max(max , dfs(i,j));
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public static int dfs(int x, int y) {
        visit[x][y] = true;
        int dx, dy, result = 1;

        for(int i = 0; i < 4; i++) {
            dx = x + move[i][0];
            dy = y + move[i][1];

            if(dx < 0 || dy < 0 || dx >= n || dy >= m) {
                continue;
            }

            if(arr[dx][dy] == 1 && !visit[dx][dy]) {
                result += dfs(dx,dy);
            }
        }

        return result;
    }
}
