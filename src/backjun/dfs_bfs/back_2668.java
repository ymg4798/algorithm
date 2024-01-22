package backjun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class back_2668 {

    static int[] node;
    static boolean[] visited;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        node = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            node[i] = Integer.parseInt(br.readLine());
        }

        result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    private static void dfs(int i, int target) {
        if (target == node[i]) {
            result.add(target);
        }

        if (!visited[node[i]]) {
            visited[node[i]] = true;
            dfs(node[i], target);
            visited[node[i]] = false;
        }
    }
}
