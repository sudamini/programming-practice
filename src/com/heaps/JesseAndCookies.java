package com.heaps;

/*
@Hacker rank
Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value.
To do this, Jesse repeatedly mixes two cookies with the least sweetness.
He creates a special combined cookie with:
sweetness= (1*Least sweet cookie +  2 * 2nd least sweet cookie).
He repeats this procedure until all the cookies in his collection have a sweetness .
Print the number of operations required to give the cookies a sweetness .
Print -1 if this isn't possible.
*/

import java.util.PriorityQueue;

public class JesseAndCookies {

    public static void main(String[] args) { // 12,3,2,1,9,10
        int[] cookies = new int[]{1, 1, 1};
        int sweetness = 10;
        int changes = cookies(sweetness, cookies);
    }

    private static int cookies(int k, int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //O(n)
        for (int i = 0; i < A.length; i++) {
            pq.add(A[i]);
        }

        int val1;
        int val2;
        int changes = 0;
        while (!pq.isEmpty() && pq.size() >= 2 && pq.peek() <= k) {
            val1 = pq.remove();
            val2 = pq.remove();
            val1 += val2 * 2;
            pq.add(val1);
            ++changes;

        }
        if (!pq.isEmpty() && pq.peek() < k) {
            return -1;
        }

        return changes;
    }

}
