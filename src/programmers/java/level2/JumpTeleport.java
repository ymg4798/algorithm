package programmers.java.level2;

public class JumpTeleport {
    public class Solution {
        public int solution(int n) {
            int ans = 0;

            while (n > 0) {
                ans += n % 2;
                n /= 2;
            }

            return ans;
        }
    }
}
