package backjun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class back_13549_re {

    static final int MAX_VALUE = 100000;
    static int[][] active = {{-1, 1}, {1, 1}, {2, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] node = new int[MAX_VALUE + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);

        Arrays.fill(node, MAX_VALUE);
        node[n] = 0;
        pq.offer(new Node(n, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int num = current.num;
            int time = current.time;

            if (node[num] < time) continue;

            for (int[] i : active) {
                int nNum = (i[0] == 2) ? num * i[0] : num + i[0];

                if (0 <= nNum && nNum <= MAX_VALUE && node[nNum] > time + i[1]) {
                    node[nNum] = time + i[1];
                    pq.offer(new Node(nNum, node[nNum]));
                }
            }
        }

        int minTime = (n >= k) ? n - k : node[k];

        System.out.println(minTime);
    }

    static class Node implements Comparable<Node>{
        int num;
        int time;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Node n) {
            return this.time - n.time;
        }
    }
}
