package com.searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
Use max heap to find kth min value from a given list.
 */
public class FindKthMin {

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 1};
        int[] arr2 = new int[]{0};
        int[] arr3 = new int[]{1, 0, 3};
        int[] arr4 = new int[]{1, 3, 4, 5, 2, 7};

        int k = 2;

        System.out.println("Second min in " + Arrays.toString(arr1) + " = " + kthMin(arr1, k));
        System.out.println("Second min " + Arrays.toString(arr2) + " = " + kthMin(arr2, k));
        System.out.println("Second min " + Arrays.toString(arr3) + " = " + kthMin(arr3, k));
        System.out.println("Second min " + Arrays.toString(arr4) + " = " + kthMin(arr4, k));

    }

    private static int kthMin(int[] arr, int k) {
        if (arr.length < 2) {
            return arr[0];
        }
        // use max heap to find kth min element
        PriorityQueue<Integer> q = new PriorityQueue<>(k + 1, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
            if (!q.isEmpty() && q.size() > k) {
                q.poll();
            }
        }
        return q.poll();


    }
}
