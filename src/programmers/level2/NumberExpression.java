package programmers.level2;

public class NumberExpression {
    public int solution(int n) {
        int answer = 1;

        for (int i = 1; i <= n/2; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if(sum >= n) break;
            }
            if (sum == n) answer++;
        }

        return answer;
    }
}
