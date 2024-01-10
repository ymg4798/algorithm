package backjun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_2206 {

    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] board;
    static boolean[][][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        board = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String[] value = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(value[j]);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, false, 1));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == N - 1 && node.y == M - 1) {
                return node.count;
            }

            for (int i = 0; i < 4; i++) {
                int dx = node.x + move[i][0];
                int dy = node.y + move[i][1];

                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }

                if (!visited[dx][dy][node.crush ? 1 : 0] && board[dx][dy] == 0) {
                    q.offer(new Node(dx, dy, node.crush, node.count + 1));
                    visited[dx][dy][node.crush ? 1 : 0] = true;
                }

                if (!visited[dx][dy][1] && board[dx][dy] == 1 && !node.crush) {
                    q.offer(new Node(dx, dy, true, node.count + 1));
                    visited[dx][dy][1] = true;
                }
            }
        }

        return -1;
    }

    static class Node {
        int x;
        int y;
        boolean crush;
        int count;

        public Node(int x, int y, boolean crush, int count) {
            this.x = x;
            this.y = y;
            this.crush = crush;
            this.count = count;
        }
    }
}
