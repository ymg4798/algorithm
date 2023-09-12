package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class leet_118 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();
        if (numRows == 0) return dp; // 체크

        dp.add(new ArrayList<>());
        dp.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev_list = dp.get(i-1);
            List<Integer> new_list = new ArrayList<>();

            new_list.add(1);
            for (int j = 1; j < prev_list.size(); j++) {
                new_list.add(prev_list.get(j-1) + prev_list.get(j));
            }
            new_list.add(1);

            dp.add(new_list);
        }

        return dp;
    }
}
