package com.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/*
@EPI
 */
public class StepsTraversal {
    public static void main(String[] args) {
        int totalSteps = 6;
        int maxStepsUCanTake = 3;
        Map<Integer, Integer> cache = new HashMap<>();
        System.out.println("Ways to climb " + totalSteps + " = " +
                totalWays(totalSteps, maxStepsUCanTake, cache));
    }

    private static int totalWays(int totalSteps, int maxStepsUCanTake, Map<Integer, Integer> map) {
        System.out.println("Parameters : Total steps =  " + totalSteps + " max steps you can take = " + maxStepsUCanTake +
                " cache = " + map);
        if (totalSteps == 2) {
            return 2;
        }
        if (totalSteps == 1) {
            return 1;
        }
        if (totalSteps == 0) {
            return 0;
        }
        int totalWays = 0;
        for (int i = 1; i <= maxStepsUCanTake && totalSteps - i > 0; i++) {
            int val;
            int param = totalSteps - i;
            if (map.containsKey(param)) {
                val = map.get(param);
            } else {
                val = totalWays(param, maxStepsUCanTake, map);
                map.put(param, val);
            }
            totalWays += val;
        }
        if (totalSteps == maxStepsUCanTake) {
            totalWays += 1;
        }
        return totalWays;
    }
}
