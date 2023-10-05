package backjun.decimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        for (int i = m; i <= n; i++) {

            if (isResult(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isResult(int i) {
        if(i <= 1) {
            return false;
        }

        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }

        return true;
    }
}
