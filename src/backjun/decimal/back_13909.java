package backjun.decimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 약수의 갯수가 홀수인 경우만 마지막에 열려있다 따라ㅓㅅ 약수가 홀수인 숫자를 찾으면 된다
 * 약수가 홀수인 경우는 제곱수 따라서 제곱수를 구해주면 된다
 */
public class back_13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (long i = 1; i*i <= n; i++) {
            count++;
        }

        System.out.println(count);
    }
}
