package backjun.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(br.readLine());

        for (int i = 0; i < p; i++) {
            String[] input = br.readLine().split(" ");

            int[] arr = new int[20];
            for (int j = 1; j <= arr.length; j++) {
                arr[j - 1] = Integer.parseInt(input[j]);
            }

            int result = 0;
            for (int j = 0; j < arr.length; j++) {
                int value = arr[j];
                for (int k = j; k < arr.length; k++) {
                    if (arr[j] > arr[k]) {
                        int temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                        result += 1;
                    }
                }
            }
            System.out.println(input[0] + " " + result);
        }
    }
}
