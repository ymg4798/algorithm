package backjun.back1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class back_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (e1, e2) -> {
            if (e1.length() == e2.length()) {
                return e1.compareTo(e2);
            }
            return e1.length() - e2.length();
        });

        System.out.println(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (!Objects.equals(arr[i - 1], arr[i])) {
                System.out.println(arr[i]);
            }
        }
    }
}
