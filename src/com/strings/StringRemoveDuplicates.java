package com.strings;

/*
GS
 */
public class StringRemoveDuplicates {

    public static void main(String[] args) {
        String str = "geeks for geeks";
        System.out.println(removeDupes(str));
    }

    private static String removeDupes(String in) {
        boolean[] seen = new boolean[256];
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (!seen[c]) {
                out.append(c);
                seen[c] = true;
            }
        }
        return out.toString();
    }
}
