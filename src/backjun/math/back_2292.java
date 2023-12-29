package backjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        if (n == 1) {
            count = 1;
        } else {
            while (n > 0) {
                n -= 6 * count;
                count++;
            }
        }

        System.out.println(count);
    }
}
