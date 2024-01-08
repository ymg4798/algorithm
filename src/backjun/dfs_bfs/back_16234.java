package backjun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_16234 {

    static int move[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;
    static int[][] input;
    static int N, L, R;
    static boolean isMove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        input = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {
            isMove = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if (!isMove) break;
            count++;
        }
        System.out.println(count);
    }

    static void bfs(int x, int y) {
        List<Node> union = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        union.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int k = 0; k < 4; k++) {
                int dx = node.x + move[k][0];
                int dy = node.y + move[k][1];

                if (isCheck(node.x, node.y, dx, dy)) {
                    isMove = true;
                    q.offer(new Node(dx, dy));
                    union.add(new Node(dx, dy));
                    visited[dx][dy] = true;
                }
            }
        }
        reconstruction(union);
    }

    static boolean isCheck(int x, int y, int dx, int dy) {
        if (dx >= 0 && dy >= 0 && dx < N && dy < N) {
            int popDiffer = Math.abs(input[x][y] - input[dx][dy]);
            return !visited[dx][dy] && popDiffer >= L && popDiffer <= R;
        }
        return false;
    }

    static void reconstruction(List<Node> list) {
        if (list.size() != 1) {
            int sum = list.stream().mapToInt(v -> input[v.x][v.y]).sum();
            int aver = sum / list.size();

            for (Node node : list) {
                input[node.x][node.y] = aver;
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
