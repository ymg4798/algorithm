import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_15903 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long arr[] = new long[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            Arrays.sort(arr);
            long value = arr[0] + arr[1];
            arr[0] = value;
            arr[1] = value;
        }
        long result = Arrays.stream(arr).sum();

        System.out.println(result);
    }

    /*
        static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++){
            Long a = pq.poll();
            Long b = pq.poll();
            pq.add(a+b);
            pq.add(a+b);
        }

        long result = 0;

        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);
    }
    */
}
