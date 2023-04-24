package backjun.back7000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String key = st.nextToken();

            if ("enter".equals(key)) {
                map.put(name, key);
            } else if ("leave".equals(key)) {
                map.remove(name);
            }
        }

        List<String> result = new ArrayList<>(map.keySet());
        result.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String value : result) {
            sb.append(value).append(' ');
        }
        System.out.println(sb);
    }
}


