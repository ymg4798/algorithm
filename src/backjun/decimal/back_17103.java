package backjun.decimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class back_17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int maxN = 0;
        int[] nArray = new int[t];
        List<Integer> decimalList = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            nArray[i] = n;
            maxN = Math.max(maxN, n);
        }

        for (int i = 2; i <= maxN; i++) {
            if (isResult(i)) {
                decimalList.add(i);
            }
        }

        for (int i = 0; i < t; i++) {
            int n = nArray[i];

            int result = 0;
            for (int j = 0; j < decimalList.size(); j++) {
                if (j > n) break;
                for (int l = j; l < decimalList.size(); l++) {
                    if (l > n) break;

                    if (decimalList.get(j) + decimalList.get(l) == n) result++;
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
