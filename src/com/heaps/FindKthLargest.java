package com.heaps;

import java.util.PriorityQueue;

/*
@leetcode
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] a = new int[]{ //3,2,3,1,2,4,5,5,6  3,2,1,5,6,4

                3, 2, 3, 1, 2, 4, 5, 5, 6
        };
        int k = 9;

        System.out.println(new FindKthLargest().findKthLargest(a, k));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);
        for (int el : nums) {
            largeK.add(el);
            if (largeK.size() > k) {
                largeK.poll();
            }
        }

        return largeK.poll();
    }
}
