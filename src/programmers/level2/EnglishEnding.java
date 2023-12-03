package programmers.level2;

import java.util.*;

public class EnglishEnding {
    public int[] solution(int n, String[] words) {

        int num = 0;
        int order = 0;
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (isCheck(set, words, i)) {
                num = i % n + 1;
                order = i / n + 1;
                break;
            }
            set.add(words[i]);
        }

        int[] answer = new int[]{num, order};

        return answer;
    }

    private boolean isCheck(Set<String> set, String[] array, int idx) {
        return set.contains(array[idx]) ||
                array[idx - 1].charAt(array[idx - 1].length() - 1) != array[idx].charAt(0);
    }

}
