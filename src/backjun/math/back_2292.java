package backjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int radius = 1;

        if (n == 1) {
            System.out.println(1);
        } else {
            int sum = 1;
            while (sum < n) {
                sum += 6 * radius;
                radius++;
            }
            System.out.println(radius);
        }
    }
}
