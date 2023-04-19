package backjun.back10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (isBinarySearch(arr, num)) {
                sb.append("1").append(" ");
            } else {
                sb.append("0").append(" ");
            }

        }
        System.out.println(sb);
    }
    private static boolean isBinarySearch(int arr[], int num) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > num) {
                right = mid - 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}


/* 헤쉬맵 해쉬셋이 더빠르다 ..
 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            map.put(Integer.parseInt(st.nextToken()), 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
 */
