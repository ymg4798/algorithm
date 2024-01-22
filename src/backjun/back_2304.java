package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class back_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            board[i][0] = Integer.parseInt(input[0]);
            board[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(board, Comparator.comparingInt(o -> o[0]));

        int maxHeight = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (maxHeight < board[i][1]) {
                maxHeight = board[i][1];
                maxIdx = i;
            }
        }

        int[] prev = board[0];
        int sum = 0;
        int maxH = prev[1];

        for (int i = 1; i <= maxIdx; i++) {
            if (maxH <= board[i][1]) {
                sum += Math.abs(board[i][0] - prev[0]) * prev[1];
                maxH = board[i][1];

                prev = board[i];
            }
        }

        prev = board[board.length - 1];
        maxH = prev[1];
        for (int i = board.length - 2; i >= maxIdx; i--) {
            if (maxH <= board[i][1]) {
                sum += Math.abs(board[i][0] - prev[0]) * prev[1];
                maxH = board[i][1];

                prev = board[i];
            }
        }

        System.out.println(sum + maxHeight);
    }
}
