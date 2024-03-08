package programmers.java.level2;

import java.util.*;

public class ChoosingTangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        quickSort(tangerine, 0, tangerine.length - 1);

        int[] countArray = new int[0];
        int before = tangerine[0];
        int count = 0;
        int idx = 0;
        for (int i : tangerine) {
            if (before == i) {
                count++;
            } else {
                countArray = add(countArray, idx++, count);
                before = i;
                count = 1;
            }
        }
        countArray = add(countArray, idx++, count);

        quickSort(countArray, 0, countArray.length - 1);

        int sum = 0;
        for (int i = 0; i < countArray.length; i++) {
            sum += countArray[i];
            if (sum >= k) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = devide(arr, start, end);

            quickSort(arr, start, pivot - 1);

            quickSort(arr, pivot + 1, end);
        }
    }

    private int devide(int[] arr, int head, int tail) {
        int left = head + 1;
        int right = tail;

        while (true) {
            while (left < tail && arr[head] < arr[left]) {
                left++;
            }

            while (arr[head] > arr[right]) {
                right--;
            }

            if (left >= right) break;

            swap(arr, left, right);

            left++;
            right--;
        }

        swap(arr, head, right);

        return right;
    }


    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private int[] add(int[] arr, int idx, int num) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[idx] = num;
        return arr;
    }
}
