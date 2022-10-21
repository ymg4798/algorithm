import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class back_9465 {
	 public static void main(String[] args) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	      StringTokenizer st;
	      
	      int t = Integer.parseInt(br.readLine());
	      
	      for(int ti = 0; ti < t; ti++) {
	         int n = Integer.parseInt(br.readLine());
	         int arr[][] = new int[n+1][2];

	         for(int i = 0; i < 2; i++) {
	            st = new StringTokenizer(br.readLine(), " ");
	            for(int j = 1; j <= n; j++) {
	               arr[j][i] = Integer.parseInt(st.nextToken());
	            }
	         }
	         
	         int max[][] = new int[n+1][2];
	         max[0][0] = arr[0][0];
	         max[0][1] = arr[0][1];
	         max[1][0] = arr[1][0];
	         max[1][1] = arr[1][1];
	         for(int i = 2; i <= n; i++) {
	            max[i][0] = Math.max(max[i-1][1] + arr[i][0], max[i-2][1] + arr[i][0]);
	            max[i][1] = Math.max(max[i-1][0] + arr[i][1], max[i-2][0] + arr[i][1]);
	         }
	         bw.write(Math.max(max[n][0], max[n][1]) + "\n");
	      }
	      
	      bw.flush();
	      bw.close();
	   }

}
