package backjun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class back_1987 {

    static int[][] move = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static int x, y;
    static String[][] boards;
    static boolean[][] visit;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        x = Integer.parseInt(size[1]);
        y = Integer.parseInt(size[0]);

        visit = new boolean[x][y];
        boards = new String[x][y];
        for (int i = 0; i < y; i++) {
            String[] value = br.readLine().split("");
            for (int j = 0; j < x; j++) {
                boards[j][i] = value[j];
            }
        }

        visit[0][0] = true;
        HashSet<String> set = new HashSet<>();
        set.add(boards[0][0]);
        dfs(0, 0, 1, set);

        System.out.println(result);
    }

    private static void dfs(int curX, int curY, int count, Set<String> set){
        for (int i = 0; i < 4; i++) {
            int dx = move[i][0] + curX;
            int dy = move[i][1] + curY;

            if (dx >= 0 && dy >= 0 && dx < x && dy < y && !set.contains(boards[dx][dy]) && !visit[dx][dy]) {
                visit[dx][dy] = true;
                set.add(boards[dx][dy]);
                dfs(dx, dy, count + 1, set);
                visit[dx][dy] = false;
                set.remove(boards[dx][dy]);
            }
        }
        result = Math.max(result, count);
    }
}
