package backjun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class back_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] arr = br.readLine().split(" ");

            int idx = Integer.parseInt(arr[0]) - 1;
            int value = Integer.parseInt(arr[1]) - 1;

            list.get(idx).add(value);
            list.get(value).add(idx);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        visit[0] = true;
        int result = 0;
        while (!q.isEmpty()) {
            Integer poll = q.poll();

            for (Integer value : list.get(poll)) {
                if (!visit[value]) {
                    visit[value] = true;
                    q.offer(value);
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
