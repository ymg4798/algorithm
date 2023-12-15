package backjun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_7576 {
    private static int[][] move = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] arr = new int[x][y];

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                int value = Integer.parseInt(st.nextToken());
                arr[j][i] = value;

                if (value == 1) {
                    q.offer(new Node(j, i, 0));
                }
            }
        }

        int result = bfs(x, y, arr, q);

        System.out.println(result);
    }

    private static int bfs(int x, int y, int[][] arr, Queue<Node> q) {
        int result = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int dx = node.x + move[i][0];
                int dy = node.y + move[i][1];

                if (dx >= 0 && dy >= 0 && dx < x && dy < y && arr[dx][dy] == 0) {
                    arr[dx][dy] = 1;
                    q.offer(new Node(dx, dy, node.count + 1));
                    result = node.count + 1;
                }
            }

        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (arr[j][i] == 0) {
                    return -1;
                }
            }
        }
        return result;
    }

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
