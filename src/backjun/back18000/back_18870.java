package backjun.back18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] tempArr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = tempArr[i] = Integer.parseInt(st.nextToken());;
        }

        Arrays.sort(tempArr);

        int rank = 0;
        for (int number : tempArr) {
            if(!map.containsKey(number)) {
                map.put(number, rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int number : arr) {
            sb.append(map.get(number)).append(' ');
        }
        System.out.println(sb);
    }
}
