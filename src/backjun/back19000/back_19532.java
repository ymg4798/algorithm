package backjun.back19000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int value1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int value2 = Integer.parseInt(st.nextToken());

        for (int i = -999; i <= 999; i++) {
            for(int j = -999; j <= 999; j++) {
                int temp1 = x1 * i + y1 * j;
                int temp2 = x2 * i + y2 * j;

                if (temp1 == value1 && temp2 == value2) {
                    System.out.println(i + " " + j);
                    break;
                }
            }
        }
    }
}
