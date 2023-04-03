package leetcode.medium;

import java.util.Arrays;

public class medium_881 {

    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        System.out.println(numRescueBoats(people, 3));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;
        int boat = 0;
        while (start <= end) {
            if (people[start] + people[end--] <= limit) {
                start++;
            }
            boat++;
        }
        return boat;
    }
}
