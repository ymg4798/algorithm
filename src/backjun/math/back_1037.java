package backjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());

            min = Math.min(min, value);
            max = Math.max(max, value);

            if (n == 1) {
                System.out.println(value * value);
                return;
            }
        }
        System.out.println(min * max);
    }
}
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(input[0] * input[0]);
            return;
        }

        int lcm = 0;
        int gcd = 0;
        int prev = input[0];
        int maxNum = input[0];
        for (int i = 1; i < n; i++) {
            int cur = input[i];
            maxNum = Math.max(maxNum, cur);

            gcd = gcd(prev, cur);
            lcm = (prev * cur) / gcd;
            prev = cur;
        }

        int result = (maxNum == lcm) ? lcm * gcd : lcm;
        System.out.println(result);
    }

    private static int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1 % num2);
    }*/


