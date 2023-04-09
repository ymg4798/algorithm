package backjun.back1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        while(N >= 0) {
            if (N % 5 == 0) {
                result += N/5;
                System.out.println(result);
                return;
            }
            N -= 3;
            result++;
        }
        System.out.println("-1");
    }

    /*
    int count = 0;
        int temp = N;
        while (0 < temp) {
            if (temp - 5 >= 0) {
                temp -= 5;
            } else if (temp - 3 >= 0) {
                temp -= 3;
            } else {
                count = -1;
                break;
            }
            count++;
        }

        int count2 = 0;
        int temp2 = N;
        while (0 < temp2) {
            if (temp2 - 3 >= 0) {
                temp2 -= 3;
            } else {
                count2 = -1;
                break;
            }
            count2++;
        }

        int count3 = 0;
        int temp3 = N;
        while (0 < temp3) {
            if (temp3 - 3 >= 0) {
                temp3 -= 3;
            } else if (temp3 - 5 >= 0) {
                temp3 -= 5;
            } else {
                count = -1;
                break;
            }
            count3++;
        }

        System.out.println(count3);
        System.out.println(count == -1 ? count2 : count);
     */
}
