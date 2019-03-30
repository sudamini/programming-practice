package com.arrays;

/*
Hackerrank
This works in current state but fails some test cases on hacker rank because this solution uses extra space.
 */
public class ArrayManipulation {
    public static void main(String[] args) {
        int[][] queries = new int[][]{
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}
        };

        int n = 5;
        System.out.println(arrayManipulation(n, queries));
    }


    private static long arrayManipulation(int n, int[][] queries) {

        long max = 0;
        long[] result = new long[n + 1];
        int columns = queries[0].length;
        int sum;
        int b1, b2;
        for (int[] a : queries) {
            sum = a[columns - 1];
            b1 = a[columns - 2];
            b2 = a[columns - 3];
            for (int i = b1; i >= b2; i--) {
                result[i] += sum;
                max = Long.max(max, result[i]);

            }
        }
        return max;
    }
}
