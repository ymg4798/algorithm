package backjun.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String value = br.readLine();

            if (value.length() >= m) {
                set.add(value);
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(set);

        list.sort((s1, s2) -> {
            int count1 = map.get(s1);
            int count2 = map.get(s2);

            if (count1 != count2) {
                return Integer.compare(count2, count1);
            }

            if (s1.length() != s2.length()) {
                return Integer.compare(s2.length(), s1.length());
            }

            return s1.compareTo(s2);
        });

        StringBuilder sb = new StringBuilder();
        for (String value : list) {
            sb.append(value).append('\n');
        }

        System.out.print(sb);
    }
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String value = br.readLine();

            if (value.length() >= m) {
                set.add(value);
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }

        String[] arr = set.toArray(new String[0]);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (isCheck(arr, map, i, j)) {
                    swap(arr, i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String value : arr) {
            sb.append(value).append('\n');
        }
        System.out.print(sb);
    }

    private static boolean isCheck(String[] arr, Map<String, Integer> map, int num1, int num2) {
        int count1 = map.get(arr[num1]);
        int count2 = map.get(arr[num2]);

        if (count2 > count1) {
            return true;
        } else if (count2 == count1) {
            if (arr[num2].length() > arr[num1].length()) {
                return true;
            } else if (arr[num2].length() == arr[num1].length()) {
                return arr[num2].compareTo(arr[num1]) < 0;
            }
        }
        return false;
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }*/
}
