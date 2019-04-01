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
64

So Output must be 1 when getMin() is called.
 */

// Use ArrayDequeue. It is supposed to be faster when used as a stack.
/*
<p>Deques can also be used as LIFO (Last-In-First-Out) stacks.  This
 * interface should be used in preference to the legacy {@link Stack} class.
 * When a deque is used as a stack, elements are pushed and popped from the
 * beginning of the deque.  Stack methods are precisely equivalent to
 * {@code Deque} methods as indicated in the table below:
 */
public class StackMinAPI {

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack();
        myStack.push(0);
        myStack.push(-1);
        myStack.push(1);
        myStack.push(-1);
        System.out.println("Get min " + myStack.getMin());
        System.out.println("Pop " + myStack.pop());
        System.out.println("Get min " + myStack.getMin());

        System.out.println("Pop " + myStack.pop());
        System.out.println("Get min " + myStack.getMin());

    }

    private static class Cache {
        Integer element;
        Integer minElement;

        // for a given element of stack, store max element at or below this element.

        public Cache(Integer element, Integer minElement) {
            this.element = element;
            this.minElement = minElement;
        }
    }

    private static class Stack<T> {

        ArrayDeque<Cache> cacheQueue;

        Stack() {
            cacheQueue = new ArrayDeque<>();
        }

        void push(int i) {
            Integer element = i;
            Integer min;
            if (isEmpty()) {
                min = i;
            } else {
                min = Integer.min(cacheQueue.peekFirst().minElement, i);
            }
            cacheQueue.addFirst(new Cache(element, min));

        }

        int pop() {
            return cacheQueue.removeFirst().element;
        }

        boolean isEmpty() {
            return cacheQueue.isEmpty();
        }

        int getMin() {
            return cacheQueue.peekFirst().minElement;
        }
    }
}
