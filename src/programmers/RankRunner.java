package programmers;

import java.util.*;

public class RankRunner {
    public static void main(String[] args) {
        String[] array = solution3(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
        System.out.println(array.length);
        for (String value : array) {
            System.out.println(value);
        }
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

    /**
     *  시간 초과
     */
    public static String[] solution2(String[] players, String[] callings) {
        String[] answer = {};

        LinkedList<String> playersToList = new LinkedList<>(Arrays.asList(players));

        for (String calling : callings) {
            int number = playersToList.indexOf(calling);

            if (number != -1) {
                String temp = playersToList.get(number - 1);
                playersToList.set(number - 1, playersToList.get(number));
                playersToList.set(number, temp);
            }
        }
        answer = playersToList.toArray(new String[playersToList.size()]);
        HashMap<String, String> map = new HashMap<>();
        for (String s : map.keySet()) {
            
        }
        return answer;
    }

    public static String[] solution3(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        HashMap<String, Integer> mapRank = new HashMap<>();
        HashMap<Integer, String> mapPlayer = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            mapRank.put(players[i], i);
            mapPlayer.put(i, players[i]);
        }

        for (String calling : callings) {
            Integer rank = mapRank.get(calling);

            String playerWin = mapPlayer.get(rank);
            String playerLose = mapPlayer.get(rank - 1);
            mapPlayer.put(rank, playerLose);
            mapPlayer.put(rank - 1, playerWin);
            mapRank.put(playerWin, rank - 1);
            mapRank.put(playerLose, rank);
        }

        for (Integer rank : mapPlayer.keySet()) {
            answer[rank] = mapPlayer.get(rank);
        }

        return answer;
    }
}
