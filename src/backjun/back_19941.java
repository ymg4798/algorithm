package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();

        int result = 0;
        for (int i = 0; i < n; i++) {
            char value = input[i];

            if (value == 'P') {
                int left = Math.max(i - k, 0);
                int right = Math.min(i + k, n - 1);

                for (int j = left; j <= right; j++) {
                    if (input[j] == 'H') {
                        input[j] = 'X';
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
