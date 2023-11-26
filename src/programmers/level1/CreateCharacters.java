package programmers.level1;

public class CreateCharacters {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isCheck = true;
        for (char c : s.toCharArray()) {
            isCheck = (c == ' ' || !isCheck);
            sb.append(isCheck ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }
        return sb.toString();
    }
}
