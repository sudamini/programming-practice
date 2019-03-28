package com.arrays;

import java.util.HashMap;
import java.util.Map;

/*
@Hackerrank
There is a collection of input strings and a collection of query strings.
For each query string, determine how many times it occurs in the list of input strings.
For example, given input strings = [  and , we find  instances of ',  of '' and  of ''.
For each query, we add an element to our return array, .
 */
public class SparseArrays {

    public static void main(String[] args) {
        String[] strIn = new String[]{
                "ab'", "ab'", "abc'"
        };
        String[] queries = new String[]{
                "ab'", "abc'", "bc'"
        };
        matchingStrings(strIn, queries);

    }

    private static int[] matchingStrings(String[] strings, String[] queries) {
        //boundary
        if (strings.length <= 0 || queries.length <= 0) {
            return new int[0];
        }
        //load strings in a hashmap
        Map<String, Integer> map = new HashMap<>();
        int val;
        for (String str : strings) {
            if (map.containsKey(str)) {
                val = map.get(str) + 1;
            } else {
                val = 1;
            }
            map.put(str, val);
        }
        int i = 0;
        int[] result = new int[queries.length];
        for (String str : queries) {
            result[i] = map.getOrDefault(str, 0);
            System.out.println(result[i]);
            ++i;
        }
        return result;

    }

}
