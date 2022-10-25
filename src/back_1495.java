import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class back_1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[M + 1];

        for(int i = 0; i <= M; i++) {
            arr[i] = -1;
        }
        arr[S] = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            int V = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= M; j++) {
                if(arr[j] == i-1) {
                    int res1 = j + V;
                    int res2 = j - V;

                    if(res1 >= 0 && res1 <= M) {
                        list.add(res1);
                    }
                    if(res2 >= 0 && res2 <= M) {
                        list.add(res2);
                    }
                }
            }
            for(int value : list) {
                arr[value] = i;
            }
        }

        int result = -1;
        for(int i = 0; i <= M; i++) {
            if(arr[i] == N) {
                result = Math.max(result, i);
            }
        }
        System.out.println(result);
    }
}