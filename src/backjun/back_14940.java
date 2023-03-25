package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_14940 {
    private static int n, m;
    private static int arr[][];
    private static boolean visit[][];
    private static int move[][] = {{1 , 0}, {0 , 1}, {0 , -1}, {-1 , 0}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        int targetX = 0, targetY = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;
                if(value == 2) {
                    targetX = i;
                    targetY = j;
                }
            }
        }
        bfs(targetX, targetY);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visit[i][j] && arr[i][j] != 0) {
                    arr[i][j] = -1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x , y});
        visit[x][y] = true;
        arr[x][y] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for(int i = 0; i < 4; i++) {
                int dx = poll[0] + move[i][0];
                int dy = poll[1] + move[i][1];

                if(dx < 0 || dy < 0 || dx >= n || dy >= m) {
                    continue;
                }

                if(arr[dx][dy] == 1 && !visit[dx][dy]) {
                    q.offer(new int[] {dx , dy});
                    arr[dx][dy] = arr[poll[0]][poll[1]] + 1;
                    visit[dx][dy] = true;
                }
            }
        }
    }
}
