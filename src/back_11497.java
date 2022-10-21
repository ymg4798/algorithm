import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_11497 { 
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st;
      int t = Integer.parseInt(br.readLine());
      int arr[];
      int n;
      
      for(int i = 0; i < t; i++) {
         n = Integer.parseInt(br.readLine());
         st = new StringTokenizer(br.readLine(), " ");
         arr = new int[n];
         for(int j = 0; j < n; j++) {
            arr[j] = Integer.parseInt(st.nextToken());
         }
         
         int result[] = new int[n];
         int left = 0;
         int right = n-1;
         Arrays.sort(arr);
         
         for(int j = 0; j < n; j++) {
            if(j%2 == 0) {
               result[left] = arr[j];
               left++;
            } else {
               result[right] = arr[j];
               right--;
            }
         }
         
         int min = Math.abs(result[0] - result[n-1]);
         for(int j = 1; j < n; j++) {
            min = Math.max(min, Math.abs(result[j] - result[j-1]));
         }
         bw.write(min + "\n");
      }
      
      bw.flush();
      bw.close();
   }
}
