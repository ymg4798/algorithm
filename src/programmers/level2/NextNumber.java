package programmers.level2;

public class NextNumber {
    public int solution(int n) {
        int curCount = count(n);
        while (curCount != count(++n)) {
        }

        return n;
    }

    private int count(int n) {
        int result = 0;

        String binaryString = Integer.toBinaryString(n);
        for (char c : binaryString.toCharArray()) {
            if (c == '1') result++;
        }

        return result;
    }
}
