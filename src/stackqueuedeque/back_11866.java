package stackqueuedeque;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        bw.append("<");
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (K == j) {
                    if (queue.size() == 1) {
                        bw.append("").append(String.valueOf(queue.poll()));
                    } else {
                        bw.append(String.valueOf(queue.poll())).append(", ");
                    }
                } else {
                    queue.offer(queue.poll());
                }
            }
        }
        bw.append(">");

        bw.flush();
    }
}
