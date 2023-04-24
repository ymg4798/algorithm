package backjun.back1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> nArr = new HashSet<>();
        for (int i = 0; i < N; i++) {
            nArr.add(br.readLine());
        }

        int count = 0;
        List<String> mArr = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String value = br.readLine();
            if(nArr.contains(value)) {
                mArr.add(value);
                count++;
            }
        }

        Collections.sort(mArr);

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for (String value : mArr) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}
