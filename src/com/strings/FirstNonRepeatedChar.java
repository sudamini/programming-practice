package com.strings;

import java.util.Map;
import java.util.LinkedHashMap;

/*
Find first non repeated character in a string
"stress" t
"teeter" r
 */
public class FirstNonRepeatedChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("iloveleetcode"));
    }

    public static int firstUniqChar(String s) {
        if (s == null || s.length() <= 0) {
            return -1;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] arr = s.toCharArray();
        int val = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = arr[i];
            if (map.containsKey(c)) {
                val = 1 + map.get(c);
            }
            map.put(c, val);
        }
        System.out.println(map);
        int i = -1;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                i = s.indexOf(e.getKey());
                break;
            }
        }
        return i;


    }

}
