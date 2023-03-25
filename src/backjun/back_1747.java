package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1747 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(true) {
            if(n == 1){
                System.out.println(n + 1);
                break;
            }

            boolean isMinor = true;
            int end = (int) Math.sqrt(n);

            for(int i = 2; i <= end; i++) {
                if(n%i == 0) {
                    isMinor = false;
                    break;
                }
            }

            if(isMinor) {
                int temp = n;
                int rev = 0;

                while(temp != 0) {
                    rev = rev*10 + temp%10;
                    temp /= 10;
                }
                if(rev == n) {
                    System.out.println(n);
                    break;
                }
            }
            n++;
        }
    }
}
