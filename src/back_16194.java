import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_16194{
        public static void main(String args[]) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());

                int N = Integer.parseInt(st.nextToken());
                int pack[] = new int[N + 1];
                int minValue[] = new int[N + 1];

                st = new StringTokenizer(br.readLine(), " ");
                for (int i = 1; i <= N; i++) {
                        pack[i] = Integer.parseInt(st.nextToken());
                        minValue[i] = Integer.MAX_VALUE;
                }

                for (int i = 1; i <= N; i++) {
                        for (int j = 1; j <= i; j++) {
                                minValue[i] = Math.min(minValue[i], minValue[i - j] + pack[j]);
                        }
                }

                System.out.println(minValue[N]);
        }
}
