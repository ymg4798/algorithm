package backjun.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);

        int[] numbers = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }

        int count = 1;
        int result = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];

            if (i >= x - 1) {
                if (sum == result) {
                    count++;
                } else if (sum > result) {
                    count = 1;
                }
                result = Math.max(result, sum);
                sum -= numbers[i - (x - 1)];
            }

        }

        if (result == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(result);
            System.out.println(count);
        }
    }
}
