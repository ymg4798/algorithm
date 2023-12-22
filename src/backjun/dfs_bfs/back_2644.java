package backjun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2644 {
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        System.out.println(bfs(new boolean[n + 1], start, end));
    }

    static int bfs(boolean[] visited, int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            if (poll[0] == end) {
                return poll[1];
            }

            for (int i = 0; i < graph[poll[0]].length; i++) {
                if (graph[poll[0]][i] == 1 && !visited[i]) {
                    q.offer(new int[]{i, poll[1] + 1});
                    visited[i] = true;
                }
            }
        }
        return -1;
    }
}
