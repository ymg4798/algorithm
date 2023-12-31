package backjun.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alpa = new int[26];
        char[] input = br.readLine().toCharArray();

        for (char value : input) {
            alpa[Character.toUpperCase(value) - 'A']++;
        }

        int max = 0;
        char result = '?';

        for (int i = 0; i < alpa.length; i++) {
            int value = alpa[i];
            if (max < value) {
                max = value;
                result = (char) ('A' + i);
            } else if (value == max) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}
