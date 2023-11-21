package programmers;

import java.util.LinkedList;

public class runner {
    public static void main(String[] args) {
        System.out.println(solution({"mumu", "soe", "poe", "kai", "mine"}));
    }

    /**
     * 시간 초과
     */
    public String[] solution(String[] players, String[] callings) {

        for (int i = 0; i < callings.length; i++) {
            String name = callings[i];
            for (int j = 1; j < players.length; j++) {
                if (name.equals(players[j])) {
                    String temp = players[j-1];
                    players[j-1] = players[j];
                    players[j] = temp;
                    break;
                }
            }
        }

        return players;
    }
}
