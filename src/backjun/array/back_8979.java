package backjun.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            Node node = new Node(country, gold, silver, bronze);
            list.add(node);
        }

        Collections.sort(list);

        Node before = list.get(0);
        int rank = 1;
        for (int i = 0; i < n; i++) {
            Node current = list.get(i);

            if (!current.isCompare(before)) rank = i + 1;

            if (current.country == k) {
                System.out.println(rank);
                break;
            }
            before = current;
        }
    }

    static class Node implements Comparable<Node> {
        int country;
        int gold;
        int silver;
        int bronze;

        public Node(int country, int gold, int silver, int bronze) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public boolean isCompare(Node node) {
            return this.gold == node.gold && this.silver == node.silver && this.bronze == node.bronze;
        }

        @Override
        public int compareTo(Node node) {
            if (this.gold == node.gold) {
                if (this.silver == node.silver) {
                    return node.bronze - this.bronze;
                }
                return node.silver - this.silver;
            }
            return node.gold - this.gold;
        }
    }
}
