package com.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @EPI
 */
public class RomanNumeralConverter {

    public static void main(String[] args) {
        Map<Integer, String> romans = new HashMap<>();
        romans.put(1, "I");
        romans.put(4, "IV");
        romans.put(5, "V");
        romans.put(9, "IX");
        romans.put(10, "X");
        romans.put(15, "XV");
        romans.put(20, "XX");
        int num = 18;
        System.out.println(Math.ceil(num));
        romans.keySet().forEach(val -> {
            if (val.equals(Math.floor(num))) {
                System.out.println(val);
            }
        });
    }
}
