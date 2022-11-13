import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_20922 {
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
            if(limit[arr[i]] < k) { // 정수 k 이하일때 최대값을 구해준다.
                end = i;
                limit[arr[end]]++;
                result = Math.max(end-start+1, result); // 최장 수열 값
            }else {
                while(true) {
                    if(arr[start] == arr[i]) {// k와 같을때 두값이 같다면 시작위치를 증가시켜주고 되돌아 가서 계산
                        start++;
                        end = i;
                        break;
                    } else { // 시작위치칸 설정..
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

