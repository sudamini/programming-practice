package com.searching;

/*
Find second minimum from a list, without sorting it, time complexity should be O(n)
@GS
 */
public class FindSecondMinimum {
    public static void main(String[] args) {
        int[] arr = new int[]{ //10,25,11,0
                11, 5, 4, 29, 32
        };
        int k = 2;
        System.out.println("Kth minimum " + kthMin(arr, k));
    }

    private static int kthMin(int[] arr, int k) {
        int firstMin = arr[0];
        int secondMin = Integer.MAX_VALUE;
        int temp;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < firstMin) {
                temp = firstMin;
                firstMin = arr[i];
                if (temp < secondMin) {
                    secondMin = temp;
                }
            } else if (arr[i] < secondMin) {
                secondMin = arr[i];
            }
        }
        return secondMin;
    }


}
