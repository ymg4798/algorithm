package programmers.level2;

public class EatLand {
    int solution(int[][] land) {
        int col = land.length;
        int row = land[0].length;

        int[][] dp = new int [col][row];
        for (int i = 0; i < row; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < col; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < row; k++) {
                    if (j == k) continue;

                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i][j]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < row; i++) {
            result = Math.max(result, dp[col - 1][i]);
        }

        return result;
    }
}
