package backjun.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class back_9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());

            int[] input = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            HashMap<Integer, Integer> teamMap = new HashMap<>();
            LinkedHashMap<Integer, Integer> playerMap = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {

            }
        }
    }
}
