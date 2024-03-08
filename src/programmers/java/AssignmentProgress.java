package programmers.java;

import java.util.*;

public class AssignmentProgress {
    public static void main(String[] args) {
        String[][] plans = {{"1", "00:00", "30"}, {"2", "00:10", "40"}, {"3", "00:20", "10"},  {"4", "00:25", "10"}, {"5", "01:10", "10"}};
        String[] solution = solution(plans);

        for (String s : solution) {
            System.out.println("s = " + s);
        }
    }

    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        for (int i = 0; i < plans.length; i++) {
            plans[i][1] = toTime(plans[i][1]);
        }

        for (int i = 1; i < plans.length; i++) {
            String[] temp = plans[i];
            int tempPlanTime = Integer.parseInt(plans[i][1]);

            int j = i - 1;
            while (j >= 0 && Integer.parseInt(plans[j][1]) > tempPlanTime) {
                plans[j + 1] = plans[j];
                j--;
            }
            plans[j + 1] = temp;
        }

        Stack<String[]> stack = new Stack<String[]>();

        int index = 0;
        int answerIndex = 0;
        int remainTime = 0;
        int size = plans.length;
        String[] current, next;
        while (size != index) {
            current = plans[index];

            String task = current[0];
            int time = Integer.parseInt(current[1]);
            int playtime = Integer.parseInt(current[2]);

            int currentTotalTime = time + playtime;

            if (size-1 != index) {
                int nextTime = Integer.parseInt(plans[index + 1][1]);
                remainTime = currentTotalTime - nextTime;
                if (currentTotalTime > nextTime) {
                    stack.push(new String[]{task, String.valueOf(remainTime)});
                    index++;
                    continue;
                }
                remainTime = nextTime - currentTotalTime;
            }

            index++;
            answer[answerIndex++] = task;

            while (!stack.isEmpty()) {
                String[] pop = stack.pop();

                int popRemainTime = Integer.parseInt(pop[1]);

                if (remainTime >= popRemainTime) {
                    answer[answerIndex++] = pop[0];
                    remainTime -= popRemainTime;
                } else {
                    stack.push(new String[]{pop[0], String.valueOf(popRemainTime - remainTime)});
                    break;
                }
            }
        }
        return answer;
    }

    public static String toTime(String plan) {
        return String.valueOf(Integer.parseInt(plan.substring(0, 2)) * 60
                + Integer.parseInt(plan.substring(3, 5)));
    }
}
