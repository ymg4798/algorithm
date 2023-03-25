package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class back_2468 {
    private static int move[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    private static int arr[][];
    private static boolean visit[][];
    private static int dx, dy;
    private static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visit = new boolean[N][N];
        List<Integer> depthList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int depth = Integer.parseInt(st.nextToken());
                arr[i][j] = depth;
                if(!depthList.contains(depth)) {
                    depthList.add(depth);
                }
            }
        }

        int answer = 0;

        if(depthList.size() == 1) {
            answer = 1;
        }

        for(int depth : depthList) {
            int safe = 0;
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] > depth && !visit[i][j]) {
                        safe += dfs(depth, i, j);
                    }
                }
            }
            visit = new boolean[N][N];
            answer = Math.max(answer, safe);
        }
        System.out.println(answer);
    }

    private static int dfs(int depth, int x, int y) {
        visit[x][y] = true;

        dx = 0;
        dy = 0;

        for(int i = 0; i < 4; i++) {

            dx = x + move[i][0];
            dy = y + move[i][1];

            if(dx < 0 || dy < 0 || dx >= N || dy >= N) {
                continue;
            }

            if(arr[dx][dy] > depth && !visit[dx][dy]) {
                dfs(depth, dx, dy);
            }
        }
        return 1;
    }
}
