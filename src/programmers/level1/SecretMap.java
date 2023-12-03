package programmers.level1;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int merged = arr1[i] | arr2[i];
            StringBuilder line = new StringBuilder();

            for (int j = 0; j < n; j++) {
                line.append((merged & 1) == 1 ? "#" : " ");
                merged >>= 1;
                System.out.println(merged);
            }

            answer[i] = line.reverse().toString();
        }

        return answer;

    }
}
