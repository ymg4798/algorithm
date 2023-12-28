package algorithm;

import java.util.Arrays;

public class Dijkstra {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 그래프를 인접 행렬로 표현
        int[][] graph = {
                {0, 1, 3, INF, INF},
                {INF, 0, 1, 6, INF},
                {INF, INF, 0, 1, INF},
                {INF, INF, INF, 0, 5},
                {INF, INF, INF, INF, 0}
        };

        // 다익스트라 알고리즘 실행 및 결과 출력
        dijkstra(graph, 0);
    }

    static void dijkstra(int[][] graph, int start) {
        int V = graph.length;
        int[] distance = new int[V]; // 각 정점까지의 최단 거리를 저장하는 배열
        boolean[] visited = new boolean[V]; // 방문한 정점을 표시하는 배열

        Arrays.fill(distance, INF); // distance 배열을 무한대(INF)로 초기화
        distance[start] = 0; // 시작 정점의 최단 거리는 0으로 설정

        for (int i = 0; i < V - 1; i++) {
            int minVertex = findMinVertex(distance, visited); // 최단 거리가 최소인 정점 선택
            visited[minVertex] = true; // 해당 정점을 방문 처리

            for (int j = 0; j < V; j++) {
                // 방문하지 않았고, 간선이 존재하며, 현재까지의 거리보다 더 짧은 경로인 경우 갱신
                if (!visited[j] && graph[minVertex][j] != INF && distance[minVertex] != INF &&
                        distance[minVertex] + graph[minVertex][j] < distance[j]) {
                    distance[j] = distance[minVertex] + graph[minVertex][j]; // 최단 거리 갱신
                }
            }
        }

        printResult(distance); // 최종적인 최단 거리 출력
    }

    static int findMinVertex(int[] distance, boolean[] visited) {
        int minDistance = INF;
        int minVertex = -1;

        // 방문하지 않은 정점 중 최단 거리가 최소인 정점 찾기
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minVertex = i;
            }
        }

        return minVertex; // 최단 거리가 최소인 정점 반환
    }

    static void printResult(int[] distance) {
        System.out.println("Vertex \t\t Distance from Source");
        // 각 정점까지의 최단 거리 출력
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + " \t\t\t\t " + distance[i]);
        }
    }
}
