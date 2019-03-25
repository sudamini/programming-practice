package com.dynamic_programming;

import java.util.Arrays;

/*
@EPI
 */
public class StepsTraversal {
    public static void main(String[] args) {
        int totalSteps = 4;
        int maxStepsUCanTake = 2;
        System.out.println("Ways to climb " + totalSteps + " = " +
                totalWays(totalSteps, maxStepsUCanTake, new int[totalSteps + 1]));
    }

    private static int totalWays(int totalSteps, int maxStepsUCanTake, int[] cache) {
        if (totalSteps <= 1) {
            return 1;
        }
        if (cache[totalSteps] == 0) {
            for (int i = 1; i <= maxStepsUCanTake && (totalSteps - i) >= 0; i++) {
                cache[totalSteps] += totalWays(totalSteps - i, maxStepsUCanTake, cache);
            }
        }
        System.out.println("Total ways " + Arrays.toString(cache));
        return cache[totalSteps];
    }
}
