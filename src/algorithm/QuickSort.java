package algorithm;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {1, 4, 5, 6, 8, 3, 2, 7};

        sortArray(a, 0, a.length - 1);

        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void sortArray(int[] array, int start, int end) {
        // 배열에 요소가 2개 이상인 경우만 정렬 진행
        if (start < end) {
            int pivot = divideArray(array, start, end);

            sortArray(array, start, pivot - 1);

            sortArray(array, pivot + 1, end);
        }
    }

    public static int divideArray(int[] a, int head, int tail) {
        int left = head + 1; // 첫 요소 + 1 부터 뒷요소로 흝어 가면서 탐색
        int right = tail; // 끝 요소부터 앞 요소로 흝어 가면서 탐색

        //기준값 head보다 작은 요소는 앞으로 큰 요소는 뒤로
        while (true) {

            // 기준 값보다 큰요소 탐색
            while (left < tail && a[head] > a[left]) {
                left++;
            }

            // 배열 끝 요소에서 앞으로 기준값보다 작은 요소 탐색
            while (a[head] < a[right]) {
                right--;
            }

            if (left >= right) break;

            swap(a, left, right);

            left++;
            right--;
        }

        swap(a, head, right);

        return right;
    }

    private static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}
