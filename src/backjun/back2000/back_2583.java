package backjun.back2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class back_2583 {

    private static int arr[][];
    private static boolean visit[][];
    private static int move[][] = {{1 , 0}, {0 , 1}, {-1 , 0}, {0 , -1}};
    private static int N, M;
    //2583
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visit = new boolean[N][M];

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int lx = Integer.parseInt(st.nextToken());
                int ly = Integer.parseInt(st.nextToken());
                int rx = Integer.parseInt(st.nextToken());
                int ry = Integer.parseInt(st.nextToken());

                for(int j = lx; j < rx; j++) {
                    for(int k = ly; k < ry; k++) {
                        arr[j][k] = 1;
                    }
                }
            }

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] == 0 && !visit[i][j]) {
                        list.add(dfs(i,j));
                    }
                }
            }

            Collections.sort(list);
            System.out.println(list.size());
            list.forEach(s -> System.out.print(s + " "));
        }

        private static int dfs(int x, int y) {
            visit[x][y] = true;

            int dx = 0, dy = 0, result = 1;

            for(int i = 0; i < 4; i++) {
                dx = x + move[i][0];
                dy = y + move[i][1];

                if(dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }

                if(arr[dx][dy] == 0 && !visit[dx][dy]) {
                    result += dfs(dx, dy);
                }
            }

            return result;
        }
   }
