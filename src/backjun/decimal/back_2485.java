package backjun.decimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class back_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Long> distince = new ArrayList<>();

        long now = Long.parseLong(br.readLine());
        for (int i = 1; i < n; i++) {
            long next = Long.parseLong(br.readLine());
            distince.add(next - now);
            now = next;
        }

        long gcdValue = distince.get(0);
        for (int i = 1; i < distince.size(); i++) {
            gcdValue = gcd(gcdValue, distince.get(i));
        }

        long result = 0;
        for (Long value : distince) {
            result = result + value/gcdValue - 1;
        }

        System.out.println(result);
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
