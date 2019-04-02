package com.stacks_queues;

import java.util.ArrayDeque;

/*
@ EPI
Returns max element from a queue in O(1)
Uses ArrayDequeue.
 */
public class QueueMaxAPI {

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(30);
        q.add(20);
        q.add(10);
        q.add(100);
        q.add(-3);

        System.out.println(q.peek()); // 30
        System.out.println(q.getMax()); //100
        System.out.println(q.poll()); //30
        System.out.println(q.poll()); //20
        System.out.println(q.getMax()); //100


    }

    private static class Cache<T> {
        Integer element;
        Integer max;

        public Cache(Integer element, Integer max) {
            this.element = element;
            this.max = max;
        }
    }

    //FIFO
    private static class Queue {
        ArrayDeque<Cache> queue;

        Queue() {
            queue = new ArrayDeque<>();
        }

        void add(int i) {
            Integer e = i;
            Integer max;
            if (queue.isEmpty()) {
                max = e;
            } else {
                max = Integer.max(queue.getLast().max, e);
            }
            queue.addLast(new Cache(e, max));
        }

        int peek() {
            return queue.getFirst().element;
        }

        int poll() {
            return queue.removeFirst().element;
        }

        boolean isEmpty() {
            return queue.isEmpty();
        }

        int getMax() {
            return queue.getLast().max;
        }
    }

}
