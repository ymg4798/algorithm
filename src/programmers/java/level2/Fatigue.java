package programmers.java.level2;

public class Fatigue {
    private boolean[] visited;
    private int length;
    private int answer;

    public int solution(int k, int[][] dungeons) {
        length = dungeons.length;
        visited = new boolean[length];

        for (int i = 0; i < length; i++) {
            visited[i] = true;
            dfs(1, k - dungeons[i][1], dungeons);
            visited[i] = false;
        }

        return answer;
    }

    private void dfs(int count, int fatigue, int[][] dungeons) {
        answer = Math.max(answer, count);

        for (int i = 0; i < length; i++) {
            int nFatigue = dungeons[i][0];
            int eFatigue = dungeons[i][1];
            if (!visited[i] && fatigue >= nFatigue) {
                visited[i] = true;
                dfs(count + 1, fatigue - eFatigue, dungeons);
                visited[i] = false;
            }
        }
    }
}
