package programmers.java.level1;

public class CaesarCipher {
    public String solution(String s, int n) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            int num = c + n;
            int value = 0;
            if (num > 90 && Character.isUpperCase(c)
                    || num > 122 && Character.isLowerCase(c)) {
                value = num - 26;
            } else if (c != 32) {
                value = num;
            } else {
                value = c;
            }

            sb.append((char) value);
        }

        return sb.toString();
    }
}
