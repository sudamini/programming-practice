package com.strings;

/*
@GS
Find first unique character in a string.
 */
public class FirstUniqueCharacter {

    public static void main(String[] args) {
        String str = "aaa";//"aaaabccf";
        System.out.println(" First unique character " + firstUniqueChar(str));
    }

    private static char firstUniqueChar(String str) {
        str = str.trim();
        char[] c = str.toCharArray();
        char firstChar = c[0];
        int i = 1;
        while (i < c.length) {
            if (c[i] != firstChar) {
                return c[i];
            }
            ++i;
        }
        return ' ';
    }
}
