package backjun.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class back_14888 {
    public static int n;
    public static int[] board;
    public static boolean[] visited;
    public static int[] number;
    public static int[] operator;
    public static List<int[]> results = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new int[n];
        visited = new boolean[n];
        number = new int[n];
        operator = new int[n - 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            int value = Integer.parseInt(st.nextToken());
            for (int j = 0; j < value; j++) {
                operator[index] = i;
                index++;
            }
        }

        dfs(0);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < results.size(); i++) {
            int[] ints = results.get(i);
            int result = ints[0];
            for (int j = 1; j < ints.length; j++) {
                int value = ints[j];
                System.out.println("result : " + result + "  value : " + value);
                switch (operator[j - 1]) {
                    case 0 :
                        result += value;
                        break;
                    case 1 :
                        result -= value;
                        break;
                    case 2 :
                        result *= value;
                        break;
                    case 3 :
                        result /= value;
                        break;
                }
            }

            max = Math.max(result, max);
            min = Math.min(result, min);
        }

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            results.add(number.clone());
            return;
        }

        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                number[depth] = board[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}

/*
public class Main {

	public static int MAX = Integer.MIN_VALUE;	// 최댓값
	public static int MIN = Integer.MAX_VALUE;	// 최솟값
	public static int[] operator = new int[4];	// 연산자 개수
	public static int[] number;					// 숫자
	public static int N;						// 숫자 개수

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		number = new int[N];

		// 숫자 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		// 연산자 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(number[0], 1);

		System.out.println(MAX);
		System.out.println(MIN);

	}

	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			// 연산자 개수가 1개 이상인 경우
			if (operator[i] > 0) {

				// 해당 연산자를 1 감소시킨다.
				operator[i]--;

				switch (i) {

				case 0:	dfs(num + number[idx], idx + 1);	break;
				case 1:	dfs(num - number[idx], idx + 1);	break;
				case 2:	dfs(num * number[idx], idx + 1);	break;
				case 3:	dfs(num / number[idx], idx + 1);	break;

				}
				// 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
				operator[i]++;
			}
		}
	}

}
 */