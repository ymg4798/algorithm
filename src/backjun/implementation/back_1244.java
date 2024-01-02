package backjun.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String student = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            int idx = 1;
            if (student.equals("1")) {
                while (true) {
                    int next = idx * num;
                    if (!(next <= n)) break;
                    arr[next] = (arr[next] % 2 == 0) ? 1 : 0;
                    idx++;
                }
            } else {
                while (true) {
                    int prev = num - idx;
                    int next = num + idx;

                    if (prev <= 0 ||  next > n || arr[prev] != arr[next] ) {
                        break;
                    }

                    arr[prev] = (arr[prev] % 2 == 0) ? 1 : 0;
                    arr[next] = (arr[next] % 2 == 0) ? 1 : 0;
                    idx++;
                }
                arr[num] = (arr[num] % 2 == 0) ? 1 : 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");

            if (i%20 == 0) System.out.println();
        }
    }
}
