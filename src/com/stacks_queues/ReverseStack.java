package com.stacks_queues;

import java.util.Stack;
/*
@GS. Uses multi level recursion to reverse a stack.
 */

public class ReverseStack {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {

        // push elements into
        // the stack
        stack.push('1');
        stack.push('2');
        stack.push('3');
        stack.push('4');

        System.out.println("Original Stack");
        System.out.println(stack);

        reverse();

        System.out.println("Reversed Stack");
        System.out.println(stack);
    }

    static void reverse() {
        if (stack.isEmpty()) {
            return;
        }
        Character c = stack.peek();
        stack.pop();
        reverse();
        insertAtBottom(c);
    }

    static void insertAtBottom(Character c) {
        if( stack.isEmpty() ){
            stack.push(c);
            return;
        }
        Character x = stack.peek();
        stack.pop();
        insertAtBottom(x);
        stack.push(x);
    }
}
