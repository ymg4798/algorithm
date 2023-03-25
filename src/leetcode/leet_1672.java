package leetcode;

import java.util.Arrays;

public class leet_1672 {

    public static void main(String[] args) {
        int[][] datas = {{1, 2, 3,}, {4, 5, 6}};

        int result = 0;
        for (int[] data : datas) {
            int total = Arrays.stream(data).sum();
            result = Math.max(result, total);
        }
    }

    //최상위 성능 답
    /*
     int max = Integer.MIN_VALUE;

     for(int row=0;row<accounts.length;row++){
         int sum=0;
         for(int col=0; col<accounts[row].length; col++){
          sum=sum+accounts[row][col];
         }
         if(sum>max){
             max=sum;
         }
     }
     return max;
    }
     */
}


