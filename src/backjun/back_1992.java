package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1992 {
    private static int arr[][];
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            String value[] = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(value[j]);
            }
        }

        confetti(0 , 0 , n);
        System.out.println(sb.toString());
    }

    private static void confetti(int x, int y, int size) throws IOException {
        if(colorCheck(x , y ,size)) {
            sb.append(arr[x][y]);
            return;
        }

        size = size / 2;

        sb.append("(");

        confetti(x, y, size);
        confetti(x, y+size, size);
        confetti(x+size, y, size);
        confetti(x+size, y+size, size);

        sb.append(")");
    }

    private static boolean colorCheck(int x, int y, int size) {
        int black = arr[x][y];

        for(int dx = x; dx < x + size; dx++) {
            for(int dy = y; dy < y + size; dy++) {
                if(black != arr[dx][dy]) {
                    return false;
                }
            }
        }

        return true;
    }

}

