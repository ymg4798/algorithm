package programmers.java.level1;

public class ThreeBinary {
    public int solution(int n) {
        int answer = 0;

        String str = threeReverse(n);
        int digit = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            answer += digit * (str.charAt(i) - 48);
            digit *= 3;
        }

        return answer;
    }

    public int solution2(int n) {
        return Integer.parseInt(threeReverse(n), 3);
    }

    private String threeReverse(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, n%3);
            n /= 3;
        }
        return sb.reverse().toString();
    }
}
