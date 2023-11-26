package programmers.level1;

public class SmallSubString {
    public int solution(String t, String p) {
        int answer = 0;
        int targetLength = t.length();
        int patternLength = p.length();

        long patternValue = Long.parseLong(p);
        for (int i = 0; i <= targetLength - patternLength; i++) {
            String currentSubstring = t.substring(i, i + patternLength);
            long currentSubValue = Long.parseLong(currentSubstring);

            if (currentSubValue <= patternValue) {
                answer++;
            }
        }

        return answer;
    }
}
