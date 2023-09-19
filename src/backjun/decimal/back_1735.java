package backjun.decimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");;

        int aNumer = Integer.parseInt(st.nextToken());
        int aDenom = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int bNumer = Integer.parseInt(st.nextToken());
        int bDenom = Integer.parseInt(st.nextToken());

        int numer , denom;

        if(aDenom != bDenom) {
            numer = aNumer * bDenom + bNumer * aDenom;
            denom = aDenom * bDenom;
        } else {
            numer = aNumer + bNumer;
            denom = aDenom;
        }

        int gcd = gcd(numer, denom);

        System.out.println(numer/gcd + " " + denom/gcd);
    }

    public static int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
