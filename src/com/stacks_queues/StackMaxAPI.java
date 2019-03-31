package com.stacks_queues;

import java.lang.Integer;
import java.util.HashMap;
import java.util.Map;
/*
@GS Implement methods push(x) and pop(x)
Design a stack that supports getMax() in O(1) time and auxiliary extra space.
Given Stack :
2
5
1
64   --> Maximum

So Output must be 64 when getMax() is called.
 */

public class StackMaxAPI {

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack();
        myStack.push(0);
        myStack.push(-1);
        myStack.push(1);
        myStack.push(-1);
    }

    private static class Stack<T> {
        int maxElement;
        int[] elementData;
        int DEFAULT_SIZE = 8;
        int current_size;
        Map<Integer, Integer> cache;

        // creates a stack with a backing array of size = DEFAULT SIZE
        Stack() {
            elementData = new int[DEFAULT_SIZE];
            maxElement = Integer.MIN_VALUE;
            current_size = 0;
            cache = new HashMap<>();
        }

        void push(int i) {
            if (i > maxElement) {
                cache.put(i, maxElement);
            }
            maxElement = Integer.max(maxElement, i); // update max element.
            elementData[current_size] = i;
            ++current_size;
        }

        int pop() {
            int i = elementData[--current_size];
            if (i == maxElement) {
                maxElement = cache.get(i);
            }
            return i;
        }

        int getMax() {
            return maxElement;
        }
    }
}
