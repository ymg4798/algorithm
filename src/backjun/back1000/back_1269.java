package backjun.back1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            String value = st.nextToken();

            if (set.contains(value)) {
                set.remove(value);
                continue;
            }
            set.add(value);
        }

        System.out.println(set.size());
    }
}
