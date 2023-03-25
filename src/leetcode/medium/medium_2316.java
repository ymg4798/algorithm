package leetcode.medium;

import java.util.*;

public class medium_2316 {
    public static void main(String[] args) {
        //int n = 3;
        //int[][] edges = {{0, 1}, {0, 2}, {1, 2}};

        int n = 7;
        int[][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};

        System.out.println(countPairs(n, edges));
    }

    static boolean visit[];
    static List<List<Integer>> datas;

    public static long countPairs(int n, int[][] edges) {
        datas = new ArrayList<>();
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            datas.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            datas.get(edge[0]).add(edge[1]);
            datas.get(edge[1]).add(edge[0]);
        }

        long sum = n;
        long result = 0;
        for (int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                int count = bfs(i, 0);
                sum -= count;
                result += (sum*count);
            }
        }

        return result;
    }

    private static int bfs(int i, int count) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        count++;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int node : datas.get(num)) {
                if (!visit[node]) {
                    queue.add(node);
                    count++;
                    visit[node] = true;
                }
            }
        }
        return count;
    }
}
