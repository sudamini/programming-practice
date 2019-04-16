package com.arrays;

import java.util.Arrays;

/*
@leetcode
 */
public class RemoveDuplicatesFromSortedArray {
    //0,0,1,1,1,2,2,3,3,4
    //1,1
    //1,1,2
    //1, 2, 2, 3, 4, 4, 4, 5, 5
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1};
        System.out.println(removeDuplicates(arr));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int len = nums.length - 1;
        int sorted_begin = 0;
        int temp;
        int unsorted_begin = sorted_begin + 1;
        int unsorted_curr = unsorted_begin;

        while (unsorted_curr <= len) {

            if (nums[unsorted_curr] > nums[sorted_begin]) {
                temp = nums[unsorted_begin];
                nums[unsorted_begin] = nums[unsorted_curr];
                nums[unsorted_curr] = temp;
                ++unsorted_begin;
                ++sorted_begin;
                ++unsorted_curr;
            } else {
                ++unsorted_curr;
            }
        }
        System.out.println(Arrays.toString(nums));
        return sorted_begin + 1;

    }
}