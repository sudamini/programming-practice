package com.strings;

/*
@EPI 6.11
 */
public class RunLengthCompression {
    public static void main(String[] args) {
        String str = "eeeffffee";//"aaaabcccaa";
        System.out.println("Input string = " + str);
        String encoded_str = encode(str);
        System.out.println("Encoded string = " + encoded_str);
        String decoded_str = decode(encoded_str);
        System.out.println("Decoded string = " + decoded_str);
    }

    private static String encode(String str) {
        int count = 1;
        int prev = 0;
        int next = 1;
        StringBuilder result = new StringBuilder(" ");
        for (int i = next; i < str.length(); i++) {
            if (str.charAt(prev) == str.charAt(i)) {
                ++count;
            } else {
                result.append(str.charAt(prev)).append(count);
                count = 1;
            }
            prev = i;
        }
        result.append(str.charAt(prev)).append(count);
        return result.toString();
    }

    private static String decode(String str) {
        StringBuilder result = new StringBuilder(" ");
        char[] ch = str.trim().toCharArray();
        int len = ch.length;
        int repeat = 0;
        int i = 0;
        while (i < len) {
            if (Character.isDigit(ch[i])) {
                repeat = Character.getNumericValue(ch[i]);
                while (repeat > 1) {
                    result.append(ch[i - 1]);
                    --repeat;
                }
            } else {
                result.append(ch[i]);
            }
            ++i;
        }
        return result.toString();
    }

}
