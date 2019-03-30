package com.maths_statistics;

/*
Check if a number is power of 10.
@GS
 */
public class PowerOfTen {
    public static void main(String[] args) {
        int n = 100000000;
        isPowerOfTen(n);
    }

    private static void isPowerOfTen(int n) {
        if (n < 10) {
            System.out.println("Not a power of 10");
            return;
        }
        int div;
        int num = n;
        while ((num / 10) > 0) {
            div = num / 10;
            num = div;
        }
        if (num % 10 == 1) {
            System.out.println("Number " + n + " is power of 10.");
        } else {
            System.out.println("Number " + n + " is not a power of 10.");
        }
    }


}
