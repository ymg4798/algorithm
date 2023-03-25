package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet_1480 {

    public static void main(String[] args) {
        int[] datas = {1, 2, 3, 4};
        int[] result = new int[datas.length];

        int total = 0;
        for (int i = 0; i < datas.length; i++) {
            total += datas[i];
            result[i] = total;
        }
    }

    //최상위 성능 답
    /*for(int i = 1; i < nums.length; i++)
    nums[i] += nums[i - 1];
        return nums;*/
}
