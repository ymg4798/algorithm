package programmers.java.level1;

public class NumFactorsAddition {
    //수정 코드
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            } else {
                answer += i;
            }
        }

        return answer;
    }

    //수정 전 코드
    public int solution2(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int count = 0;
            int number = i;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count % 2 == 1) {
                number = i * -1;
            }
            answer += number;
        }

        return answer;
    }

}
