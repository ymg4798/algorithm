package backjun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class back_1260 {
    static int n, m;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        int v = Integer.parseInt(arr[2]);

        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            String[] vArr = br.readLine().split(" ");
            int a = Integer.parseInt(vArr[0]);
            int b = Integer.parseInt(vArr[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(new boolean[n + 1], v);
        System.out.println();
        bfs(new boolean[n + 1], v);
    }

    static void dfs(boolean[] visited, int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                dfs(visited, i);
            }
        }
    }

    static void bfs(boolean[] visited, int node) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);

        while (!q.isEmpty()) {
            int poll = q.poll();
            System.out.print(poll + " ");

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[poll][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                }
            }

        }
    }

}
