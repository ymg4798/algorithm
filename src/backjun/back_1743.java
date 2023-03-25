package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1743 {
    private static int move[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static int arr[][];
    private static boolean visit[][];
    private static int dx = 0;
    private static int dy = 0;
    private static int N = 0;
    private static int M = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r][c] = 1;
        }

        int answer = 0;
        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < M+1; j++) {
                if(arr[i][j] == 1 && !visit[i][j]) {
                    answer = Math.max(answer, dfs(i, j));
                }
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int x, int y) {
        visit[x][y] = true;

        dx = 0;
        dy = 0;
        int total = 1;

        for(int i = 0; i < 4; i++) {
            dx = x + move[i][0];
            dy = y + move[i][1];

            if(dx <= 0 || dy <= 0 || dx > N || dy > M) {
                continue;
            }

            if(arr[dx][dy] == 1 && !visit[dx][dy]) {
                total += dfs(dx, dy);

            }
        }
        return total;
    }
}
