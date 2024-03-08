package programmers.java.level2;

public class NDecimalGame {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        int num = 0;
        int count = 0;
        while(sb.length() < t) {
            String str = Integer.toString(num, n);

            for (char c : str.toCharArray()) {
                count++;
                if (count == p && sb.length() < t) {
                    sb.append(Character.toUpperCase(c));
                }
                if (count == m) {
                    count = 0;
                }
            }
            num++;
        }

        return sb.toString();
    }
}
