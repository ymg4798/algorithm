package programmers.java.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringDesc {

    // 한 줄 코드
    public String reverseStr(String str) {
        char[] sol = str.toCharArray();
        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).reverse().toString();
    }

    public String reverseStr2(String str) {
        return Stream.of(str.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
    }

    // 내 코드
    public String solution(String s) {
        String answer = "";
        String[] array = s.split("");

        for (int i = 1; i < array.length; i++) {
            String temp = array[i];

            int j = i - 1;

            while (j >= 0 && array[j].charAt(0) < temp.charAt(0)) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = temp;
        }

        return Arrays.stream(array).collect(Collectors.joining());
    }
}
