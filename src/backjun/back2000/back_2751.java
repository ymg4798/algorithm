package backjun.back2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//출력시 걸리는 시간도 고려를 해야한다 ...
public class back_2751 {

    private static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        sorted = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(arr, 0, N-1);

        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }

    private static void merge_sort(int[] a, int left, int right) {
        if (left == right) return;

        int mid = (left + right) / 2;
        merge_sort(a, left, mid);
        merge_sort(a, mid + 1, right);

        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            sorted[idx++] = (a[l] <= a[r]) ? a[l++] : a[r++];
        }
        while (r <= right) {
            sorted[idx++] = a[r++];
        }
        while (l <= mid) {
            sorted[idx++] = a[l++];
        }

        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }
}

/*
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int number : arr) {
            System.out.println(number);
        }
 */