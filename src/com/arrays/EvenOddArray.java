package com.arrays;

import java.util.Arrays;

/*
@EMI
 */
public class EvenOddArray {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 2, 0, 4, 8, 9, 11, 13, 17, 6, 1, 1};
        evenOdd(arr);
    }

    private static void evenOdd(int[] arr) {
        int temp = -1;
        int len = arr.length;

        for (int i = 0, j = len - 1; i < j; i++, j--) {
            while (arr[i] % 2 == 0 && i < len - 1 && i < j) {
                ++i;
            }
            while (arr[j] % 2 != 0 && j > 0 && j > i) {
                --j;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
