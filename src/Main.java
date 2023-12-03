import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {
        solution(new int[]{2, 6, 8, 14});
    }

    public static int solution(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int first = arr[i - 1];
            int second = arr[i];
            int a = 0;
            while (first != second) {
                if (first < second) {
                    first += arr[i-1];
                } else {
                    second += arr[i];
                }
                a++;
            }
            System.out.println(first + " " + second);
            arr[i] = second;
        }

        return arr[arr.length - 1];
    }
}