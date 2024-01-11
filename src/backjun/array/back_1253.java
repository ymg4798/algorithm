package backjun.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] input = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        int result = 0;
        for (int i = 0; i < N; i++) {
            int right = N - 1;
            int left = 0;

            while (left < right) {

                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                long sum = input[left] + input[right];

                if (sum == input[i]) {
                    result++;
                    break;
                }

                if (sum > input[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(result);
    }
}
