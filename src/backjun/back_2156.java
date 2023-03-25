package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_2156 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+1];
		int max[] = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		max[1] = arr[1];
		if(n > 1) {
			max[2] = arr[1] + arr[2];
		}
		for(int i = 3; i <= n; i++) {
			max[i] = Math.max(max[i-1], Math.max(max[i-2] + arr[i], max[i-3] + arr[i-1] + arr[i]));
		}
		System.out.println(max[n]);
	}
}
