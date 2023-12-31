package backjun.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class back_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            list.add(new Person(weight, height));
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;
            Person current = list.get(i);
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                Person compare = list.get(j);
                if (current.height < compare.height &&
                        current.weight < compare.weight) {
                    rank++;
                }
            }
            System.out.println(rank);
        }
    }

    static class Person {
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
