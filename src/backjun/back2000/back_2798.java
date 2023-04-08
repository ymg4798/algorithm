package backjun.back2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> values = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            values.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(values);

        int max = 0;

        int NValueLength = values.size() - 1;
        int third = NValueLength;
        int second = NValueLength - 1;
        int first = NValueLength - 2;

        while(third >= 2) {
            int hap = values.get(third) + values.get(second) + values.get(first);
            if (hap <= M) {
                max = Math.max(max, hap);
            }

            if (first == 0 && second == 1) {
                third--;
                second = third - 1;
                first = second - 1;
            } else if (first == 0) {
                second--;
                first = second - 1;
            }  else {
                first--;
            }
        }

        System.out.println(max);
    }
}

/*
브루트 포스 알고리즘 <- 얘가 더 빠르넹 ... ㅠ
for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for(int t = j + 1; t < N; t++) {
                    int hap = NValue[i] + NValue[j] + NValue[t];
                    if (hap <= M) {
                        max = Math.max(max, hap);
                    }
                }
            }
        }
 */
