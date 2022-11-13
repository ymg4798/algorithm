import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int start = 0;
        int end = 0;
        int limit[] = new int[100001];
        limit[arr[start]]++;

        for(int i = 1; i < n; i++){
            if(limit[arr[i]] < k) {
                end = i;
                limit[arr[end]]++;
                result = Math.max(end-start+1, result);
            }else {
                while(true) {
                    if(arr[start] == arr[i]) {
                        start++;
                        end = i;
                        break;
                    } else {
                        limit[arr[start]]--;
                        start++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
/*
  for(int j = i; j < n; j++) {
        rtemp++;
        temp[arr[j]]++;
        if(temp[arr[j]] > k) {
        result = Math.max(result, rtemp-1);
        rtemp = 0;
        } else if(j == n-1) {
        result = Math.max(result, rtemp);
        rtemp = 0;
        }
        }
        temp = new int[100001]; 시간초과 ... */