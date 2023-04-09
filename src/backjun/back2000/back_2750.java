package backjun.back2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int temp = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 1; j < N - i; j++) {
                if (arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int value : arr) {
            System.out.println(value);
        }
    }
}
