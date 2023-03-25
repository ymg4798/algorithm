package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_4307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tcase = 0; tcase < t; tcase++){
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int acount = Integer.parseInt(st.nextToken());

            int shortMax = 0;
            int longMax = 0;
            for (int i = 0; i < acount; i++) {
                int ant = Integer.parseInt(br.readLine());
                shortMax = Math.max(shortMax, Math.min(ant, l-ant));
                longMax = Math.max(longMax, Math.max(ant, l-ant));
            }
            System.out.println(shortMax + " " + longMax);
        }
    }
}

