package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11052 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int pack[] = new int[N + 1];
		int maxValue[] = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			pack[i] = Integer.parseInt(st.nextToken());
		}

		maxValue[0] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				maxValue[i] = Math.max(maxValue[i], maxValue[i - j] + pack[j]);
			}
		}
		System.out.println(maxValue[N]);
	}
}
