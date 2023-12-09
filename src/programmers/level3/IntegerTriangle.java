package programmers.level3;

public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int height = triangle.length;

        if (height == 1) {
            return triangle[0][0];
        }

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int leftValue = (j > 0) ? triangle[i - 1][j - 1] : 0;
                int rightValue = (j < triangle[i - 1].length) ? triangle[i - 1][j] : 0;

                triangle[i][j] += Math.max(leftValue, rightValue);
            }
        }

        int answer = 0;
        for (int value : triangle[height - 1]) {
            answer = Math.max(answer, value);
        }

        return answer;
    }
}
