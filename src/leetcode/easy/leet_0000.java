package leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class leet_0000 {
    static int N;
    static int[][] countries;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        int[] x1 = {10, 30, 65, 10};
        int[] x2 = {15, 40, 40, 70};
        int[] y1 = {40, 65, 80, 30};
        int[] y2 = {40, 60, 70, 90};

        N = 4;
        countries = new int[N][4];
        adj = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                countries[i][0] = x1[i];
                countries[i][1] = x2[i];
                countries[i][2] = y1[i];
                countries[i][3] = y2[i];
            }
            adj[i] = new ArrayList<>();
        }

        // 각 나라 간에 연결성 판단
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                                         if ((countries[i][0] == countries[j][2] || countries[i][2] == countries[j][0])
                        && countries[i][1] <= countries[j][3] && countries[j][1] <= countries[i][3]) {
                    adj[i].add(j);
                    adj[j].add(i);
                } else if ((countries[i][1] == countries[j][3] || countries[i][3] == countries[j][1])
                        && countries[i][0] <= countries[j][2] && countries[j][0] <= countries[i][2]) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        // 각 나라의 연결된 나라의 수 출력
        for (int i = 0; i < N; i++) {
            System.out.println(adj[i].size());
        }
    }
}
