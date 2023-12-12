package programmers.level2;

import java.util.*;

public class ParkingCalculate {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Parking> map = new HashMap<>();

        for (String recode : records) {
            String[] arr = recode.split(" ");

            String number = arr[1];
            int time = toIntTime(arr[0]);

            Parking parking = map.get(number);
            if (parking == null) {
                map.put(number, new Parking(time, arr[2], 0));
            } else {
                if (parking.state.equals("IN")) {
                    parking.diff += time - parking.time;
                }
                parking.time = time;
                parking.state = arr[2];
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        int[] answer = new int[map.size()];
        int idx = 0;
        for (String key : keySet) {
            Parking parking = map.get(key);
            if (parking.state.equals("IN")) {
                parking.diff += 1439 - parking.time;
            }
            answer[idx++] = parking.charge(fees);
        }

        return answer;
    }

    private int toIntTime(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }

    class Parking {
        int time;
        String state;
        int diff;

        public Parking(int time, String state, int diff) {
            this.time = time;
            this.state = state;
            this.diff = diff;
        }

        public int charge(int[] fees) {
            int exceedTime = Math.max(0, diff - fees[0]);
            return fees[1] + (int) Math.ceil((double) exceedTime / fees[2]) * fees[3];
        }
    }
}
