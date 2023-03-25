package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_3184 {
    private static String arr[][];
    private static boolean visit[][];
    private static int move[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int result[] = new int[2];
    private static int r, c;
    private static int sheep = 0, wolf = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new String[r][c];
        visit = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String value[] = br.readLine().split("");
            for(int j = 0; j < c; j++) {
                arr[i][j] = value[j];
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if((arr[i][j].equals("v") || arr[i][j].equals("o")) && !visit[i][j]) {
                    dfs(i, j);
                    if(sheep > wolf) {
                        result[0] += sheep;
                    } else {
                        result[1] += wolf;
                    }
                    sheep = 0;
                    wolf = 0;
                }
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        int dx = 0, dy = 0;

        if(arr[x][y].equals("v")) {
            wolf++;
        } else if(arr[x][y].equals("o")){
            sheep++;
        }

        for(int i = 0; i < 4; i++) {
            dx = x + move[i][0];
            dy = y + move[i][1];

            if(dx < 0 || dy < 0 || dx >= r || dy >= c) {
                continue;
            }

            if(!arr[dx][dy].equals("#") && !visit[dx][dy]) {
                dfs(dx, dy);
            }
        }
    }
}
