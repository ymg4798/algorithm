package backjun.back1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_1446 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        List<Road> roads = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int shortcut = Integer.parseInt(st.nextToken());
            if(end > d) continue;
            if(end - start <= shortcut) continue;
            roads.add(new Road(start, end ,shortcut));
        }

        Collections.sort(roads);

        int index = 0;
        int move = 0;
        int dist[] = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while (move < d) {
            if(index < roads.size()) {
                Road r = roads.get(index);
                if(move == r.start) {
                    dist[r.end] = Math.min(dist[move] + r.shortcut, dist[r.end]);
                    index++;
                } else {
                    dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                    move++;
                }
            } else {
                dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                move++;
            }
        }
        System.out.println(dist[d]);
    }

    static class Road implements Comparable<Road>{
        int start, end, shortcut;
        public Road(int start, int end, int shortcut) {
            this.start = start;
            this.end = end;
            this.shortcut = shortcut;
        }
        @Override
        public int compareTo(Road r) {
            if(this.start == r.start) return this.end - r.end;
            return this.start - r.start;
        }
    }
}

