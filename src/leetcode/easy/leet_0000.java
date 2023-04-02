package leetcode.easy;

import java.util.List;
import java.util.ArrayList;

class leet_0000 {
        public int solution(int[] pays, String[][] infos, String[] target) {
            int answer = 0;

            List<Integer> payArr = new ArrayList<>();
            for (String[] info : infos) {
                if (info[0].equals(target[0]) && info[1].equals(target[1])) {
                }
            }

            double average = payArr.stream().mapToDouble(pay -> pay).average().orElse(0.0);
            double maxAverage = average * 1.8;
            double minAverage = average * 0.2;

            answer = payArr.stream().filter(pay -> (maxAverage <= pay && minAverage >= pay)).mapToInt(pay -> pay).sum();

            return answer == 0 ? (int) average : answer/payArr.size();
        }
    }
