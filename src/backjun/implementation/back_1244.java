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
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            String student = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (student.equals("1")) {
                int idx = 1;
                while (idx <= n) {
                    arr[idx * num] = (arr[idx * num] % 2 == 0) ? 1 : 0;
                }
            } else {
                int idx = 1;
                int prev = num - idx;
                int next = num + idx;
                while (prev > 0 && next <= n) {
                    if (arr[prev] != arr[next]) {
                        break;
                    }
                    arr[prev] = (arr[prev] % 2 == 0) ? 1 : 0;
                    arr[next] = (arr[next] % 2 == 0) ? 1 : 0;
                }
                arr[num] = (arr[num] % 2 == 0) ? 1 : 0;
            }
        }
    }
}
