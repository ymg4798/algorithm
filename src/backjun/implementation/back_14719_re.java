package backjun.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_14719_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] input = new int[w];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < w; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 1; i < w; i++) {
            int left = 0; int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, input[j]);
            }

            for (int j = w - 1; j > i; j--) {
                right = Math.max(right, input[j]);
            }

            result += Math.max(0, Math.min(left, right) - input[i]);
        }

        System.out.println(result);
    }
}
