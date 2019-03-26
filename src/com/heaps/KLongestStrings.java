package com.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
@EPI
Find top k longest strings from given array
e.g. find top 3 longest strings.:
 */
public class KLongestStrings {

    public static void main(String[] args) {
        String[] str = new String[]{
                "a",
                "tttttttt",
                "abcgggg",
                "fffffffffffffffffffffffffff",
                "efggg",
                "abcbbbbbbbbb",
                "defgdefgfggggggggggg",
        };
        int k = 3;
        PriorityQueue<String> q = findKLongest(str, k);
        System.out.println("queue " + q);
    }

    /*
    Find top 3 longest strings
     */
    private static PriorityQueue<String> findKLongest(String[] str, int k) {

        PriorityQueue<String> queue = new PriorityQueue<>(k, Comparator.comparing(String::length));

        for (int i = 0; i < str.length; i++) {
            // remove the shortest length string from priority queue if we
            // get a string that has larger length
            if (!queue.isEmpty() && queue.peek().length() < str[i].length()) {
                queue.remove();
            }
            queue.add(str[i]);
        }
        return queue;
    }

}
