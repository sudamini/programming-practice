package com.stacks_queues;

import java.util.*;

/*
@GS recursively sorts a stack by making use of only stack methods.
Pops a value from stack and stores in a local method stack.
 */
public class SortStack {

    public static void main(String[] args) {
        ArrayDeque<Integer> givenStack = new ArrayDeque<>();
        givenStack.push(1);
        givenStack.push(200);
        givenStack.push(0);
        givenStack.push(7);
        givenStack.push(12);
        givenStack.push(4);
        givenStack.push(40);
        givenStack.push(2);

        new SortStack().sortStack(givenStack);

    }

    void sortStack(ArrayDeque<Integer> given) {
        if (given.isEmpty()) {
            return;
        }
        int temp = given.pop();
        sortStack(given);
        given = makeSorted(given, temp);
        System.out.println(given);
    }

    ArrayDeque<Integer> makeSorted(ArrayDeque<Integer> given, int newElement) {
        if (given.isEmpty() || given.peek() > newElement) {
            given.push(newElement);
            return given;
        }
        int temp = given.pop();
        makeSorted(given, newElement);
        given.push(temp);
        return given;
    }
}
