package backjun.combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class back_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");

        /*Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(array[i]);
            for (int j = 2; j * j <= num; j++) {
                int count = 0;
                while (num % j == 0) {
                    count++;
                    num /= j;
                }

                if (count > 0) {
                    map.put(j, Math.max(map.getOrDefault(j, 1), count));
                }
            }

            if (num != 1) {
                map.put(num, Math.max(map.getOrDefault(num, 0), 1));
            }
        }

        int result = 1;
        for (Integer value : map.keySet()) {
            result *= Math.pow(value, map.get(value));
        }

        System.out.println(result);*/
    }
}
