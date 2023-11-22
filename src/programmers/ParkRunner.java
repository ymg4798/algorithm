package programmers;

public class ParkRunner {

    /**
     * 1번 솔루션 ... for문이 너무 많다 ..
     */
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] answer = new int[2];

            String[][] map = new String[50][50];

            int x = 0;
            int y = 0;
            for (int i = 0; i < park.length; i++) {
                String[] arr = park[i].split("");
                for (int j = 0; j < arr.length; j++) {
                    map[i][j] = arr[j];

                    if (arr[j].equals("S")) {
                        x = i;
                        y = j;
                    }
                }
            }

            for (String route : routes) {
                String[] value = route.split(" ");
                int move = Integer.parseInt(value[1]);
                boolean isCheck = true;

                if (value[0].equals("E")) {
                    for (int i = 1; i <= move; i++) {
                        isCheck = isCheckFunc(x, y + i, map);
                        if (!isCheck) break;
                    }
                    if (isCheck) y += move;
                } else if (value[0].equals("W")) {
                    for (int i = 1; i <= move; i++) {
                        isCheck = isCheckFunc(x, y - i, map);
                        if (!isCheck) break;
                    }
                    if (isCheck) y -= move;
                } else if (value[0].equals("S")) {
                    for (int i = 1; i <= move; i++) {
                        isCheck = isCheckFunc(x + i, y, map);
                        if (!isCheck) break;
                    }
                    if (isCheck) x += move;
                } else if (value[0].equals("N")) {
                    for (int i = 1; i <= move; i++) {
                        isCheck = isCheckFunc(x - i, y, map);
                        if (!isCheck) break;
                    }
                    if (isCheck) x -= move;
                }
            }

            answer[0] = x;
            answer[1] = y;
            return answer;
        }

        public boolean isCheckFunc(int x, int y, String[][] map) {
            return x >= 0 && y >= 0 && x < 50 && y < 50 && map[x][y] != null && !map[x][y].equals("X");
        }
    }

    /**
     * 솔루션 2 깔끔해짐!
     */
    private int n, m;
    private String[][] map;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int[] solution2(String[] park, String[] routes) {
        int[] answer = new int[2];

        int x = 0;
        int y = 0;
        n = park.length;
        m = park[0].length();
        map = new String[n][m];


        for (int i = 0; i < park.length; i++) {
            String[] arr = park[i].split("");
            for (int j = 0; j < arr.length; j++) {
                map[i][j] = arr[j];

                if (arr[j].equals("S")) {
                    x = i;
                    y = j;
                }
            }
        }

        for (String route : routes) {
            String[] value = route.split(" ");
            int move = Integer.parseInt(value[1]);
            boolean isSuccess = true;

            int curX = x;
            int curY = y;
            int op = findOpNumber(value[0]);

            for (int i = 0; i < move; i++) {
                curX += dx[op];
                curY += dy[op];

                isSuccess = isCheck(curX, curY);
                if (!isSuccess) break;

                if (i == move - 1) {
                    x = curX;
                    y = curY;
                }
            }
        }

        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    private int findOpNumber(String op) {
        switch (op) {
            case "N":
                return 0;
            case "S":
                return 1;
            case "E":
                return 2;
            case "W":
                return 3;
        }
        return 99;
    }

    private boolean isCheck(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m && !map[x][y].equals("X");
    }

}
