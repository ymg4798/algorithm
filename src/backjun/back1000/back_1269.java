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
        List<Long> aList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            aList.add(Long.parseLong(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        List<Long> bList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            bList.add(Long.parseLong(st.nextToken()));
        }

    }
}
