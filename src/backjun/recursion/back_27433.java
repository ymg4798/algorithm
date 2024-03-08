package backjun.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_27433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(fac(n));
    }

    private static long fac(int n) {
        if (n <= 1) return 1L;
        return n * fac(n - 1);
    }
}
