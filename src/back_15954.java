import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_15954 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        double result = Double.MAX_VALUE;//최소 값을 얻기 위한 최댓값
        while(k <= n) {
            for (int i = 0; i <= n - k; i++) {// k이상의 수를 새어야 하므로 n-k가된다.

                double m = 0.0;
                for (int j = 0; j < k; j++) {
                    m += arr[j + i];
                }
                m = m / k;

                double deviation = 0.0;
                for (int j = 0; j < k; j++) {
                    deviation += Math.pow(arr[j + i] - m, 2);
                }
                deviation = Math.sqrt(deviation / k);
                result = Math.min(result, deviation);
            }
            k++;
        }
        System.out.println(String.format("%.11f",result));
    }
}
