package backjun.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2512_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int left = 0;
        int right = 0;
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, input[i]);
        }

        long total = Long.parseLong(br.readLine());
        while (left <= right) {
            int mid = (int) ((left + right) / 2);
            long sum = 0L;

            for (int i = 0; i < n; i++) {
                if (input[i] > mid) sum += mid;
                else sum += input[i];
            }

            if (sum <= total) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
