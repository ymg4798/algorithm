import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2178 {
    private static int move[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static int arr[][];
    private static boolean visit[][];
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] a = st.nextToken().split("");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(a[j]);
            }
        }

        bfs();
        System.out.println(arr[N-1][M-1]);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0 , 0});

        visit[0][0] = true;

        while(!q.isEmpty()) {
            int[] poll = q.poll();

            for(int i = 0; i < 4; i++) {
                int x = poll[0] + move[i][0];
                int y = poll[1] + move[i][1];

                if(x < 0 || y < 0 || x >= N || y >= M) {
                    continue;
                }

                if(arr[x][y] == 1 & !visit[x][y]) {
                    q.offer(new int[] {x, y});
                    arr[x][y] = arr[poll[0]][poll[1]] + 1;
                    visit[x][y] = true;
                }
            }
        };
    }

}
