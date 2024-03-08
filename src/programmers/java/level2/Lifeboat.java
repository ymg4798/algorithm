package programmers.java.level2;

public class Lifeboat {
    public int solution(int[] people, int limit) {

        quickSort(people, 0 , people.length - 1);

        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) left++;
            right--;
            answer++;
        }

        return answer;
    }

    private void quickSort(int[] people, int start, int end) {
        if (start < end) {
            int pivot = devide(people, start, end);

            quickSort(people, start, pivot - 1);

            quickSort(people, pivot + 1, end);
        }
    }

    private int devide(int[] people, int head, int tail) {
        int left = head + 1;
        int right = tail;

        while(true) {
            while(left < right && people[head] > people[left]) {
                left++;
            }

            while(people[head] < people[right]) {
                right--;
            }

            if (left >= right) break;

            swap(people, left, right);

            left++;
            right--;
        }

        swap(people, head, right);

        return right;
    }

    private void swap(int[] people, int left, int right) {
        int temp = people[left];
        people[left] = people[right];
        people[right] = temp;
    }
}
