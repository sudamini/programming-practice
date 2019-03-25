package com.arrays;

/*
@EMI
 */
public class AdvanceByOffsets {

    public static void main(String[] args) {
        int arr[] = new int[]{3, 3, 1, 0, 2, 0, 1};
        // int arr[] = new int[] { 3,2,0,0,2,0,1};
        new AdvanceByOffsets().advance(arr);
    }

    private void advance(int[] arr) {
        int furthestSoFar = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            furthestSoFar = Math.max(furthestSoFar, arr[i] + i);
            if (i == furthestSoFar) {
                break;
            }
        }
        System.out.println(furthestSoFar);
        if (furthestSoFar >= len - 1) {
            System.out.println("Possible");
        } else {
            System.out.println("not possible");
        }
    }
}
