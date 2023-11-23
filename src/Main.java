import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        String[][] a = {{"1", "2"}, {"2", "3"}};

        String[] b = a[0];
        String c = b[0]
                ;
        Stack<String[]> stack = new Stack<>();
        System.out.println(stack.pop()[0]);


        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}