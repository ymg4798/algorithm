package backjun.back1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int result = 666;
        while(count < N) {
            String resultStr = String.valueOf(result);
            if (resultStr.contains("666")) {
                count++;
            }
            result++;
        }
        System.out.println(result - 1);
    }
}
