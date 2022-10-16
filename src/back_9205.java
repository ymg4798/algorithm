import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_9205 {
    private static int n, sx, sy, dx, dy;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            List<int []> list = new ArrayList<>();
            for(int j = 0; j < n+2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(j == 0){
                    sx = x;
                    sy = y;
                } else if (j == n+1) {
                    dx = x;
                    dy = y;
                } else {
                    list.add(new int[]{x,y});
                }
            }
            System.out.println(bfs(list));
        }
    }

    private static String bfs(List<int[]> list) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[n];
        q.add(new int[] {sx, sy});

        while(!q.isEmpty()) {
            int[] cos = q.poll();
            int cx = cos[0], cy = cos[1];

            if (Math.abs(cx - dx) + Math.abs(cy - dy) <= 1000) {
                return "happy";
            }

            for(int i = 0; i < n; i++) {
                if (!visit[i]) {
                    int nx = list.get(i)[0], ny = list.get(i)[1];
                    int dis = Math.abs(cx - nx) + Math.abs(cy - ny);
                    if (dis <= 1000) {
                        visit[i] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return "sad";
    }
}
