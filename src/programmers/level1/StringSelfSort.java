package programmers.level1;

public class StringSelfSort {
    public String[] solution(String[] strings, int n) {
        for (int i = 1; i < strings.length; i++) {
            String temp = strings[i];
            int j = i - 1;

            while (j >= 0 && compareStrings(strings[j], temp, n) > 0) {
                strings[j + 1] = strings[j];
                j--;
            }

            strings[j + 1] = temp;
        }

        return strings;
    }

    private int compareStrings(String str1, String str2, int index) {
        char char1 = str1.charAt(index);
        char char2 = str2.charAt(index);

        if (char1 == char2) {
            return str1.compareTo(str2);
        } else {
            return Character.compare(char1, char2);
        }
    }
}
