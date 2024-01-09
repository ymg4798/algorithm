package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);

        int[] belt = new int[N];

        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] type = new int[d + 1];
        int count = 0;

        type[c]++;
        count++;

        for (int i = 0; i < k; i++) {
            if (type[belt[i]] == 0) {
                count++;
            }
            type[belt[i]]++;
        }

        int max = count;

        for (int i = 1; i < N; i++) {
            int end = (i + k - 1) % N;

            if (type[belt[end]] == 0) count++;
            type[belt[end]]++;

            type[belt[i - 1]]--;
            if (type[belt[i - 1]] == 0) count--;

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
