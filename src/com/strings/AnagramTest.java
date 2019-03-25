package com.strings;

import java.util.Arrays;

/*
@hackerrank
 */
public class AnagramTest {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "dac";
        System.out.println("Are two strings anagrams - " + testMe(str1, str2));
    }

    private static boolean testMe(String str1, String str2) {
        boolean ret = false;
        if (str1.length() != str2.length()) {
            return ret;
        }
        char[] c1 = str1.trim().toCharArray();
        Arrays.sort(c1);
        char[] c2 = str2.trim().toCharArray();
        Arrays.sort(c2);
        for (int i = 0; i < str1.length(); i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

}
