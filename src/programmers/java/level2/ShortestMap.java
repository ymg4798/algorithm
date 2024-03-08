package programmers.java.level2;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestMap {
    private int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private int xSize, ySize;
    private boolean[][] visited;

    public int solution(int[][] maps) {
        xSize = maps.length;
        ySize = maps[0].length;
        visited = new boolean[xSize][ySize];

        return bfs(maps, 0, 0);
    }

    public int bfs(int[][] arr, int x, int y) {
        visited[x][y] = true;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));

        while(!q.isEmpty()) {
            Node node = q.poll();

            if(node.x == xSize - 1 && node.y == ySize - 1) {
                return node.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = move[i][0] + node.x;
                int ny = move[i][1] + node.y;

                if (nx < 0 || ny < 0 || nx >= xSize || ny >= ySize) {
                    continue;
                }

                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, node.depth + 1));
                }
            }
        }
        return -1;
    }

    class Node {
        int x;
        int y;
        int depth;

        public Node (int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
