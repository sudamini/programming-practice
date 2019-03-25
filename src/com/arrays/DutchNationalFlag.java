package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
@EMI
 */
public class DutchNationalFlag {

    public static void main(final String[] args) {
        //int[] arr = new int[] {2,1,6,5,2,1,4,3,2,7};
        int[] arr = new int[]{2, 1, 6, 5, 2, 1, 4, 3, 2, 7};
        int pivot_idx = 4;
        //rearrangeExtraSpace( arr, pivot_idx);
        //rearrangeExtraTime( arr, pivot_idx );
        rearrangeNoExtraTime(arr, pivot_idx);
    }

    /**
     * This uses O(n) extra space and O(n) time. Uses three lists - for equal, smaller and greater elements and merges them in the end.
     *
     * @param arr
     * @param pivot_indx
     */
    private static void rearrangeExtraSpace(int[] arr, int pivot_indx) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[pivot_indx]) {
                less.add(arr[i]);
            } else if (arr[i] == arr[pivot_indx]) {
                equal.add(arr[i]);
            } else {
                greater.add(arr[i]);
            }
        }
        less.addAll(equal);
        less.addAll(greater);

        System.out.println("Old array " + Arrays.toString(arr));
        System.out.println("New array " + less);
    }

    /**
     * This uses two for loops. O(n2) and no extra space.
     * The second for loop searches for 1) element less than pivot and swaps it with element in outer subarray 2) breaks.
     * 1) element greater than pivot and swaps it with element in outer subarray 2) breaks.
     *
     * @param arr
     * @param pivot_idx
     */
    private static void rearrangeExtraTime(int[] arr, int pivot_idx) {
        int temp = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[pivot_idx]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    break;
                }
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[pivot_idx]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    break;
                }
            }
        }

        System.out.println("array " + Arrays.toString(arr));
    }

    /**
     * This has two for loops. O(n)
     *
     * @param arr
     * @param pivot_idx
     */
    // 2,1,6,5,2,1,4,3,2,7
    private static void rearrangeNoExtraTime(int[] arr, int pivot_idx) {
        int smaller = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[pivot_idx]) {
                int temp = arr[smaller];
                arr[smaller] = arr[i];
                arr[i] = temp;
                ++smaller;
            }
        }
        int larger = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > arr[pivot_idx]) {
                int temp = arr[larger];
                arr[larger] = arr[i];
                arr[i] = temp;
                --larger;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
