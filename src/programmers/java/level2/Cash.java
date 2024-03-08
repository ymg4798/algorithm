package programmers.java.level2;

public class Cash {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        String[] cacheArr = new String[cacheSize];

        for (String city : cities) {
            city = city.toLowerCase();

            int idx = indexOf(cacheArr, city);
            answer += (idx != -1) ? 1 : 5;

            LRU(cacheArr, city, (idx != -1) ? idx : cacheSize - 1);
        }
        return answer;
    }

    private int indexOf(String[] arr, String city) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(city)) {
                return i;
            }
        }
        return -1;
    }

    private void LRU(String[] arr, String value, int idx) {
        while (idx > 0) {
            arr[idx] = arr[idx - 1];
            idx--;
        }
        arr[0] = value;
    }
}
