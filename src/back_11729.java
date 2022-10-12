import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class back_11729{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        BigInteger n = new BigInteger("2");
        BigInteger k = n.pow(num).subtract(BigInteger.ONE);
        System.out.println(k);

        if(num < 21) {
            hanoi(num, 1, 2, 3);
        }
    }

    private static void hanoi (int num, int s, int m, int e) {
        if(num == 1) {
            System.out.println(s + " " + e);
        } else {
            hanoi(num-1, s, e, m);
            System.out.println(s + " " + e);
            hanoi(num-1, m, s, e);
        }
    }
}
