import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_6064 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = x;
            int temp = x;
            int max = lcm(M, N);
            while(true) {
                int ty = temp % N == 0 ? N : temp % N;
                if (ty == y) {
                    break;
                }

                temp = ty + M;
                result += M;
                if(result > max){
                    result = -1;
                    break;
                }
            }
            System.out.println(result);
        }
    }

    private static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }

    private static int lcm(int a, int b) {
        return (a * b)/ gcd(a,b);
    }
}
