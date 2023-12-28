package backjun.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1205_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int n = Integer.parseInt(arr[0]);
        long score = Long.parseLong(arr[1]);
        int p = Integer.parseInt(arr[2]);

        if (n == 0) {
            System.out.println(1);
            return;
        }

        String[] scoreList = br.readLine().split(" ");

        if (n == p && score <= Long.parseLong(scoreList[n - 1])) {
            System.out.println(-1);
        } else {
            int rank = 1;
            for (int i = 0; i < n; i++) {
                if (score < Long.parseLong(scoreList[i])) {
                    rank++;
                } else break;
            }
            System.out.println(rank);
        }
    }
}
