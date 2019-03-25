package com.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/*
@EPI
 */
public class Fibonacci {
    private static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        //0 1 1 2 3 5
        int num = 2;
        long curr = System.currentTimeMillis();
        System.out.println(fibNoRecursion(num));
        long fut = System.currentTimeMillis();
        System.out.println(" time taken " + (fut - curr));
    }

    private static int fib(int num) {
        if (num <= 1) {
            return num;
        } else if (!cache.containsKey(num)) {
            cache.put(num, fib(num - 1) + fib(num - 2));
        }
        return cache.get(num);
    }

    private static int fibNoRecursion(int num) {
        if (num <= 1) {
            return num;
        }
        int prev = 0;
        int curr = 1;
        int next = -1;
        for (int i = 2; i <= num; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        System.out.println("fib " + num + " = " + next);
        return next;
    }
}
