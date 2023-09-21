package backjun.decimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());

            if (num == 1 || num == 0) {
                num = 2;
            }

            for(long j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    num++;
                    j = 1;
                }
            }

            result[i] = num;
        }

        for (long value : result) {
            System.out.println(value);
        }
    }
}
