package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class back_2667 {
	private static int move[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	private static int arr[][];
	private static boolean visit[][];
	private static int dx = 0;
	private static int dy = 0;
	private static int N = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] a = st.nextToken().split("");
			for (int j = 0; j < a.length; j++) {
				arr[i][j] = Integer.parseInt(a[j]);
			}
		}

		List<Integer> resultList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					resultList.add(dfs(i, j));
				}
			}
		}

		System.out.println(resultList.size());
		Collections.sort(resultList);
		resultList.forEach(System.out::println);
	}

	private static int dfs(int x, int y) {
		visit[x][y] = true;

		dx = 0;
		dy = 0;
		int result = 1;

		for (int i = 0; i < 4; i++) {
			dx = x + move[i][0];
			dy = y + move[i][1];

			if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
				continue;
			}

			if (arr[dx][dy] == 1 && !visit[dx][dy]) {
				result += dfs(dx, dy);
			}
		}
		return result;
	}
}
