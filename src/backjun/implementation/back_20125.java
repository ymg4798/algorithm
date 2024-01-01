package backjun.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] board = new String[n][n];

        Node heart = null;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (heart == null && input[j].equals("*")) heart = new Node(i + 1, j);
                board[i][j] = input[j];
            }
        }

        System.out.println((heart.x + 1) + " " + (heart.y + 1));

        int aLeft = 0;
        for (int i = heart.y - 1; i >= 0; i--) {
            if (board[heart.x][i].equals("*")) {
                aLeft++;
            } else {
                break;
            }
        }

        int aRight = 0;
        for (int i = heart.y + 1; i < n; i++) {
            if (board[heart.x][i].equals("*")) {
                aRight++;
            } else {
                break;
            }
        }

        int body = 0;
        Node bottom = null;
        for (int i = heart.x + 1; i < n; i++) {
            if (board[i][heart.y].equals("*")) {
                body++;
            } else {
                bottom = new Node(i - 1, heart.y);
                break;
            }
        }

        int lLeft = 0;
        for (int i = bottom.x + 1; i < n; i++) {
            if (board[i][bottom.y - 1].equals("*")) {
                lLeft++;
            } else {
                break;
            }
        }

        int lRight = 0;
        for (int i = bottom.x + 1; i < n; i++) {
            if (board[i][bottom.y + 1].equals("*")) {
                lRight++;
            } else {
                break;
            }
        }

        System.out.println(aLeft + " " + aRight + " " + body + " " + lLeft + " " + lRight);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
