package backjun.back1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1342 {
   public static char alphabet[] = new char[26];
   public static int result;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = br.readLine();
      
      for(int  i = 0; i < str.length(); i++) {
         alphabet[str.charAt(i) -'a']++;
      }
      
      dfs(0, "", str.length());
      
      System.out.println(result);
   }
   
   public static void dfs(int idx, String temp, int len) {
      
      if(idx == len) {
         result++;
      }
      
      for(int i = 0; i < 26; i++) {
         if(alphabet[i] == 0) {
            continue;
         }
         if(temp != "" && temp.charAt(temp.length() - 1) == (char)('a' + i)) {
            continue;
         }
         alphabet[i]--;
         dfs(idx + 1, temp + (char)('a' + i), len);
         alphabet[i]++;
      }
   }
}

