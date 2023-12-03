package programmers.level2;

public class NLCM {
    public int solution(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int first = arr[i - 1];
            int second = arr[i];

            arr[i] = (first * second)/gcd(first, second);
        }

        return arr[arr.length - 1];
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
