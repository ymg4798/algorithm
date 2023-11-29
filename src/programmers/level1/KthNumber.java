package programmers.level1;

public class KthNumber {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for (int i = 0; i < commands.length; i++) {
                int[] command = commands[i];

                int start = command[0];
                int end = command[1];
                int k = command[2];

                int[] subArray = new int[end - start + 1];
                int idx = 0;
                for (int j = start - 1; j < end; j++) {
                    subArray[idx++]  = array[j];
                }

                for (int j = 1; j < subArray.length; j++) {
                    int temp = subArray[j];

                    int l = j - 1;

                    while (l >= 0 && subArray[l] > temp) {
                        subArray[l + 1] = subArray[l];
                        l--;
                    }

                    subArray[l + 1] = temp;
                }

                answer[i] = subArray[k - 1];
            }

            return answer;
        }
    }
}
