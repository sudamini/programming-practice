package com.strings;

import java.util.*;

/*
@hackerrank
 */
public class MakeAnagrams {

    public static void main(String[] args) {
        String str1 = "cde";
        String str2 = "abc";

        int deletions = makeAnagrams(str1, str2);
        System.out.println("minimum deletions " + deletions);
    }

    private static int makeAnagrams(String a, String b) {
        int deletions = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        int val;
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (map1.containsKey(ch)) {
                val = map1.get(ch);
                val = val + 1;
            } else {
                val = 1;
            }
            map1.put(ch, val);
        }
        System.out.println("map of first string " + map1);

        char[] c = b.toCharArray();
        Arrays.sort(c);

        for (int i = 0; i < c.length; i++) {
            char ch = c[i];
            if (map1.containsKey(ch) && map1.get(ch) > 0) {
                val = map1.get(ch);
                map1.put(ch, --val);
            } else {
                ++deletions;
            }
        }
        Collection<Integer> vals = map1.values();
        for (int i : vals) {
            if (i <= 0) {
                continue;
            } else {
                deletions = deletions + i;
            }
        }

        /* for( int i = 0; i < str2.length(); i++ ){
            if( map2.containsKey(str2.charAt(i))){
                val = map2.get(str2.charAt(i));
                val = val + 1;
            } else {
                val = 1;
            }
            map2.put(str2.charAt(i),val);
        }
        System.out.println(map1);
        System.out.println(map2);

        if( map1.equals(map2)) {
            return 0;
        }

        Set<Character> set1 = map1.keySet();
        Set<Character> set2= map2.keySet();
        Set<Character> driver;
        Set<Character> follower;
        if( set1.size() >= set2.size() ){
            driver = set1;
            follower = set2;
        } else {
            driver = set2;
            follower = set1;
        }
        int deletions=0;
        int val1, val2;
        for ( Character c:driver ) {
            val1 = map1.get(c);
            if(follower.contains(c)) {
                val2 = map2.get(c);
                 if( val1 == val2 ) {
                     continue;
                 } else {
                     deletions = deletions + Math.abs(val1 - val2);
                 }
            }
            else {
                deletions = deletions + val1;
            }
        } */

        return deletions;
    }

}

