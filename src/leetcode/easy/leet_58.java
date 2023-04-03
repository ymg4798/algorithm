package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leet_58 {

    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}
