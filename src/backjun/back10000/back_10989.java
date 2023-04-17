package backjun.back10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 카운팅 정렬
 * 1. Array에서의 Max값 필요
 * 2. CountingArray에서 array에서의 갯수를 세어준다
 * 3. CountingArray누적 작업을 한다.
 * 4. Array값에서 Counting으로가서 Value에 맞는 Counting을 차감해주고 결과 테이블에 저장한다.
 */
public class back_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] counting = new int[10001];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            counting[array[i]]++;
        }

        for(int i = 1; i < counting.length; i++) {
            counting[i] += counting[i-1];
        }

        for (int i = N - 1; i >= 0; i--) {
            int value = array[i];
            counting[value]--;
            result[counting[value]] = value;
        }

        StringBuilder sb = new StringBuilder();
        for(int number : result) {
            sb.append(number).append('\n');
        }
        System.out.print(sb);
    }
}
