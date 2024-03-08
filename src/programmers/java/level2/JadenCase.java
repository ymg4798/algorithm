package programmers.java.level2;

public class JadenCase {
    //첫 코드
    public String solution(String s) {
        String[] array = s.split("");

        boolean isCheck = true;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].isBlank()) {
                char c = array[i].charAt(0);

                if (Character.isDigit(c)) {
                    isCheck = false;
                    continue;
                }

                if (isCheck) {
                    array[i] = array[i].toUpperCase();
                    isCheck = false;
                } else {
                    array[i] = array[i].toLowerCase();
                }
            } else {
                isCheck = true;
            }
        }
        return String.join("", array);
    }

    // 수정 코드
    public String solution2(String s) {
        String[] array = s.split("");
        boolean isCheck = true;
        for (int i = 0; i < array.length; i++) {
            array[i] = (isCheck) ? array[i].toUpperCase() : array[i].toLowerCase();
            isCheck = array[i].equals(" ");
        }

        return String.join("", array);
    }
}
