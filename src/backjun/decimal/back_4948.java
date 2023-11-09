package backjun.decimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            int result = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isResult(i)) {
                    result++;
                }
            }

            System.out.println(result);
        }
    }

    private static boolean isResult(int i) {
        if (i == 1) return false;

        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }

        return true;
    }
}
