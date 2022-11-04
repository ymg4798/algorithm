import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<Integer>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<Integer>();
        for(int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        int count = 0;
        int sum = 0;
        while(!bridge.isEmpty()) {
            sum -= bridge.poll();
            if(!truck.isEmpty()) {
                if(sum + truck.peek() <= l) {
                    int value = truck.poll();
                    sum += value;
                    bridge.offer(value);
                } else {
                    bridge.offer(0);
                }
            }
            count++;
        }
        System.out.println(count);
    }
}

