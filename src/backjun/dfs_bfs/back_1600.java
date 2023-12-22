package backjun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1600 {
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] mMove = {{-1, 2}, {-2, 1}, {1, 2}, {2, 1}, {-2, -1}, {-1, -2}, {2, -1}, {1, -2}};
    static boolean[][][] visited;
    static int[][] board;
    static int w, h, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        String[] area = br.readLine().split(" ");
        w = Integer.parseInt(area[0]);
        h = Integer.parseInt(area[1]);

        board = new int[w][h];
        visited = new boolean[w][h][k + 1];

        for (int i = 0; i < h; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                board[j][i] = Integer.parseInt(arr[j]);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, k, 0));
        visited[0][0][k] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x + 1 == w && node.y + 1 == h) {
                return node.result;
            }

            for (int i = 0; i < 4; i++) {
                int dx = node.x + move[i][0];
                int dy = node.y + move[i][1];

                if (isCheck(dx, dy, node.k)) {
                    q.add(new Node(dx, dy, node.k, node.result + 1));
                    visited[dx][dy][node.k] = true;
                }
            }

            if (node.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int dx = node.x + mMove[i][0];
                    int dy = node.y + mMove[i][1];

                    if (isCheck(dx, dy, node.k - 1)) {
                        q.add(new Node(dx, dy, node.k - 1, node.result + 1));
                        visited[dx][dy][node.k - 1] = true;
                    }
                }
            }
        }

        return -1;
    }

    static boolean isCheck(int x, int y, int k) {
        return x >= 0 && y >= 0 && x < w && y < h && !visited[x][y][k] && board[x][y] == 0;
    }

    static class Node {
        int x;
        int y;
        int k;
        int result;

        public Node(int x, int y, int k, int result) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.result = result;
        }
    }
}
