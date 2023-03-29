package leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class leet_0000 {
    public static String[] main(String[] args) {
        solution();
    }

    public String[] solution() {
        String[][] C = {{"PUSH","www.domain1.com"},{"PUSH","www.domain2.com"},{"PUSH","www.domain3.com"},{"BACK","1"},{"BACK","1"},{"PUSH","www.domain4.com"}};

        int currentPage = 0;

        List<String> historys = new LinkedList<>();
        for (String[] value : C) {
            if ("BACK".equals(value[0]) && currentPage != 0) {
                currentPage--;
            } else if ("NEXT".equals(value[0]) && currentPage < historys.size() - 1) {
                currentPage++;
            } else if ("PUSH".equals(value[0])) {
                if (historys.size() != 0) {
                    for (int i = currentPage + 1; i < historys.size(); i++) {
                        historys.remove(i);
                    }
                }
                historys.add(value[1]);
                currentPage = historys.size() - 1;
            }
        }

        return historys.toArray(new String[historys.size()]);
    }

    public String[] solution(String[][] C) {
        int currentPage = 0;

        List<String> historys = new LinkedList<>();
        for (String[] value : C) {
            if ("BACK".equals(value[0]) && currentPage != 0) {
                currentPage--;
            } else if ("NEXT".equals(value[0]) && currentPage < historys.size() - 1) {
                currentPage++;
            } else if ("PUSH".equals(value[0])) {
                int count = currentPage + 1;
                while (count < historys.size()) {
                    historys.remove(i);
                }
                historys.add(value[1]);
                currentPage = historys.size() - 1;
            }
        }

        for (int i = 0; i < historys.size(); i++) {
            if(historys.contains(historys.get(i))) {
                historys[i];
            }
        }

        return historys.toArray(new String[historys.size()]);
    }

}
