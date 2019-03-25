package com.strings;

/**
 * @EPI Makes allowances of case, punctuations and word dividers
 */
public class Palindrome {

    public static void main(String[] args) {
        //String str = "racecar";
        //String str = "AbBA";
        //String str = "Yash";
        String str = "A man, a plan, a canal, Panama!";
        System.out.println(isPalindrome(str));
    }

    private static boolean isPalindrome(String str) {
        int begin = 0;
        int end = str.length() - 1;
        boolean isPalindrome = true;
        str = str.toLowerCase();
        Character beg, en;
        while (begin < end) {
            beg = str.charAt(begin);
            en = str.charAt(end);
            if (Character.isWhitespace(beg) || !Character.isLetterOrDigit(beg)) {
                ++begin;
                continue;
            }
            if (Character.isWhitespace(en) || !Character.isLetterOrDigit(en)) {
                --end;
                continue;
            }

            if (str.charAt(begin) == str.charAt(end)) {
                ++begin;
                --end;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
