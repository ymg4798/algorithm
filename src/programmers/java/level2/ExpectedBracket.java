package programmers.java.level2;

public class ExpectedBracket {
    public int solution(int n, int a, int b) {
        int answer = 0;

        for (int i = 1; i <= n/2; i++) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;

            if (a == b) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
