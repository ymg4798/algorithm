package backjun.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class back_26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            if (set.contains(input[0]) || set.contains(input[1])) {
                set.add(input[1]);
                set.add(input[0]);
            }
        }

        System.out.println(set.size());
    }
}


