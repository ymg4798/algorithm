package programmers.level1;

public class DivisorMultiple {
    public int[] solution(int n, int m) {
        int multiply =  n * m;
        int gcd = gcd(n, m);

        int[] answer = new int[] {gcd, multiply / gcd};

        return answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
