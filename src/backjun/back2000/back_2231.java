package backjun.back2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int intN = Integer.parseInt(N);
        int minN = N.length() * 9;

        for (int i = intN - minN; i < intN; i++) {
            int temp = i;
            int sum = i;
            while (temp > 0) {
                sum += temp%10;
                temp /= 10;
            }

            if (sum == Integer.parseInt(N)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
