package backjun.back1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1018 {

    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new String[N][M];

        for (int i = 0; i < N; i++) {
            String[] bwValue = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = bwValue[j];
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++){
            for(int j = 0; j < M - 7; j++) {
                result = Math.min(result, find(i, j));
            }
        }
        System.out.println(result);
    }

    private static int find(int x, int y) {
        int dx = x + 8;
        int dy = y + 8;
        String bw = arr[x][y];

        int result = 0;
        for (int i = x; i < dx; i++) {
            for (int j = y; j < dy; j++) {
                if (!bw.equals(arr[i][j])) {
                    result++;
                }
                bw = color(bw);
            }
            bw = color(bw);
        }
        return Math.min(result, 64 - result);
    }

    private static String color(String bw) {
        if ("B".equals(bw)){
            return "W";
        }
        return "B";
    }
}
// 첫문제에 있는 첫번째 색과 그 반대되는 색을 햇을ㄱ때중의 최솟값을 반환해줘야한다.