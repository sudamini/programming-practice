package com.stacks_queues;

import java.lang.Integer;
import java.util.ArrayDeque;

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

// Use ArrayDequeue. It is supposed to be faster when used as a stack.
/*
<p>Deques can also be used as LIFO (Last-In-First-Out) stacks.  This
 * interface should be used in preference to the legacy {@link Stack} class.
 * When a deque is used as a stack, elements are pushed and popped from the
 * beginning of the deque.  Stack methods are precisely equivalent to
 * {@code Deque} methods as indicated in the table below:
 */
public class StackMaxAPI {

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack();
        myStack.push(0);
        myStack.push(-1);
        myStack.push(1);
        myStack.push(-1);
        System.out.println("Get max " + myStack.getMax());
        System.out.println("Pop " + myStack.pop());
        System.out.println("Get max " + myStack.getMax());

        System.out.println("Pop " + myStack.pop());
        System.out.println("Get max " + myStack.getMax());

    }

    private static class Cache {
        Integer element;
        Integer maxElement;

        // for a given element of stack, store max element at or below this element.

        public Cache(Integer element, Integer maxElement) {
            this.element = element;
            this.maxElement = maxElement;
        }
    }

    private static class Stack<T> {

        ArrayDeque<Cache> cacheQueue;

        Stack() {
            cacheQueue = new ArrayDeque<>();
        }

        void push(int i) {
            Integer element = i;
            Integer max;
            if (isEmpty()) {
                max = i;
            } else {
                max = Integer.max(cacheQueue.peekFirst().maxElement, i);
            }
            cacheQueue.addFirst(new Cache(element, max));

        }

        int pop() {
            return cacheQueue.removeFirst().element;
        }

        boolean isEmpty() {
            return cacheQueue.isEmpty();
        }

        int getMax() {
            return cacheQueue.peekFirst().maxElement;
        }
    }
}
