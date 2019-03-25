package com.dynamic_programming;

/*
@EPI
 */
public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 7, 2, 0};
        //int[] arr = new int[]{904,40,523,12,-335,-385,-124,481,-31};
        //int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4}; //?????
        //int[] arr = new int[]{-1,-2};
        maxSubArraySum(arr);
        maxSubArrayDynamicProgramming(arr);
    }

    /*
    O(n2) two for loops.
     */
    private static void maxSubArraySum(int[] arr) {
        return;
    }

    /*
    binary
     */
    private static void maxSubArrayDivideConcur(int[] arr) {

    }

    /*
    O(n)
     */
    private static void maxSubArraySingleLoop(int[] arr) {

    }
    /*
       O(n) solution using dynamic programming. Uses no additional space.
     */

    private static int maxSubArrayDynamicProgramming(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sumSoFar = nums[0];
        int max = sumSoFar;
        int curr;
        for (int i = 1; i < nums.length; i++) {
            curr = nums[i];
            if (curr > curr + sumSoFar) {
                sumSoFar = curr;
            } else {
                sumSoFar = curr + sumSoFar;
            }
            max = Integer.max(sumSoFar, max);
        }
        System.out.println(max);
        return max;
    }


}
