package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_23971_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);
        int m = Integer.parseInt(input[3]);

        int a = (int) Math.ceil(h/(n+1));
        int b = (int) Math.ceil(w/(m+1));

        System.out.println(a*b);
    }
}
