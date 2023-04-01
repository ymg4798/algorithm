package leetcode.easy;

public class leet_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() -1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /*
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String smallestWord = strs[0];
        String longestWord = strs[strs.length - 1];
        int index = 0;

        while (index < smallestWord.length()) {
            if (smallestWord.charAt(index) == longestWord.charAt(index)) {
                index++;
            }
            else {
                break;
            }
        }

        return smallestWord.substring(0, index);
    }
     */
}
