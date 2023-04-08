package backjun.back2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2630 {
    private static int white = 0, blue = 0;
    private static int arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        confetti(0 , 0 , n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void confetti(int x, int y, int size) {
        if(colorCheck(x , y ,size)) {
            if(arr[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        size = size / 2;

        confetti(x+size, y, size);
        confetti(x, y+size, size);
        confetti(x, y, size);
        confetti(x+size, y+size, size);
    }

    private static boolean colorCheck(int x, int y, int size) {
        int color = arr[x][y];

        for(int dx = x; dx < x + size; dx++) {
            for(int dy = y; dy < y + size; dy++) {
                if(color != arr[dx][dy]) {
                    return false;
                }
            }
        }

        return true;
    }

}

