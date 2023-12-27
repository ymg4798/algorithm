package backjun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_1726 {

    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] mn = br.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        int[][] board = new int[n + 1][m + 1];
        boolean[][][] visited = new boolean[n + 1][m + 1][5];

        for (int i = 1; i <= m; i++) {
            String[] bValue = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                board[j][i] = Integer.parseInt(bValue[j - 1]);
            }
        }

        int[] start = toArrayInt(br.readLine().split(" "));
        int[] end = toArrayInt(br.readLine().split(" "));

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start[1], start[0], start[2], 0));
        visited[start[1]][start[0]][start[2]] = true;

        while (!q.isEmpty()) {
            Node poll = q.poll();
            int d = poll.direction;

            if (poll.x == end[1] && poll.y == end[0] && poll.direction == end[2]) {
                System.out.println(poll.count);
                break;
            }

            for (int i = 1; i <= 3; i++) {
                int dx = move[d - 1][0] * i + poll.x;
                int dy = move[d - 1][1] * i + poll.y;

                if (dx <= 0 || dy <= 0 || dx > n || dy > m) continue;

                if (board[dx][dy] == 1) break;

                if (!visited[dx][dy][d]) {
                    visited[dx][dy][d] = true;
                    q.offer(new Node(dx, dy, d, poll.count + 1));
                }
            }

            for (int i = 1; i <= 4; i++) {
                if (i == d || visited[poll.x][poll.y][i]) continue;

                visited[poll.x][poll.y][i] = true;

                int plus = (isCheck(d, i)) ? 2 : 1;
                q.offer(new Node(poll.x, poll.y, i, poll.count + plus));
            }
        }
    }

    static int[] toArrayInt(String[] arr) {
        int[] nInt = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nInt[i] = Integer.parseInt(arr[i]);
        }
        return nInt;
    }

    static boolean isCheck(int cur, int next) {
        return ((next == 4 && cur == 3) || (next == 3 && cur == 4)
                || (next == 1 && cur == 2) || (next == 2 && cur == 1));
    }

    static class Node {
        int x;
        int y;
        int direction;
        int count;

        public Node(int x, int y, int direction, int count) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", direction=" + direction +
                    ", count=" + count +
                    '}';
        }
    }
}
