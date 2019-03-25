package com.strings;

import java.util.HashMap;
import java.util.Map;

/*
@EPI
 */
public class IntegerStringConversion {

    public static void main(String[] args) {
        int num = 12345678;
        //convertToStringLarge( num );
        //convertToStringSmall( num );
        String str = "123";
        convertToInteger(str);
    }

    /**
     * This converts numbers from 1- 999999999
     * //TODO how to convert Integer.MIN_VALUE and INTEGER.MAX_VALUE
     *
     * @param num
     */
    private static void convertToStringLarge(int num) {
        boolean pos = (num < 0) ? false : true;
        if (!pos) {
            num = Math.abs(num);
        }
        int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999};
        int size = -1;
        for (int i = 0; i < sizeTable.length; i++) {
            if (num <= sizeTable[i]) {
                size = i + 1;
                break;
            }
        }

        Map<Integer, Integer> divisors = new HashMap<>();
        divisors.put(1, 1);
        divisors.put(2, 10);
        divisors.put(3, 100);
        divisors.put(4, 1000);
        divisors.put(5, 10000);
        divisors.put(6, 100000);
        divisors.put(7, 1000000);
        divisors.put(8, 10000000);
        divisors.put(9, 100000000);

        int divisor = -1;
        StringBuilder result = new StringBuilder(" ");
        if (!pos) {
            result.append("-");
        }
        for (int i = size; i > 0; i--) {
            divisor = divisors.get(i);
            result.append(num / divisor);
            num = num % divisor;
        }

        System.out.println("result = " + result);
    }

    private static void convertToStringSmall(int num) {
        boolean pos = (num < 0) ? false : true;
        if (!pos) {
            num = Math.abs(num);
        }

        double floor;
        int div, mod, floor_int;
        StringBuilder result = new StringBuilder(" ");
        if (!pos) {
            result.append("-");
        }
        while (true) {
            floor = Math.floor(num);
            floor_int = (int) floor;
            div = num / floor_int;
            result.append(div);
            mod = num % floor_int;
            if (mod <= 0) {
                break;
            }
            num = mod;
        }
        System.out.println(result);
    }

    private static void convertToInteger(String str) {
        int base_multiplier = 10;
        int expo = 0;
        int num = 0;
        int val;
        //val = (int) Math.pow(base_multiplier,expo);
        for (int i = str.length() - 1; i >= 0; i--) {
            val = (int) Math.pow(base_multiplier, expo);
            ++expo;
            if (!Character.isDigit(str.charAt(i))) {
                continue;
            }
            num = num + Character.getNumericValue(str.charAt(i)) * val;
        }
        System.out.println(num);
    }


}


