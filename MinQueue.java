package com.algorithms.qartks;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by qartks on 2/28/17.
 */
public class MinQueue {

    Queue<Integer> mainQueue;
    Queue<Integer> minQueue;

    public  MinQueue() {
        mainQueue = new LinkedList<>();
        minQueue = new LinkedList<>();
    }

    public void enqueue(int x) {
        mainQueue.add(x);

        Iterator<Integer> it = minQueue.iterator();
        while (it.hasNext()) {
            int val = it.next();
            if (x < val) {
                it.remove();
            }
        }
        minQueue.add(x);
    }

    public int dequeue() {
        if (!mainQueue.isEmpty()) {
            int val = mainQueue.poll();
            if (val == findMin()) {
                minQueue.poll();
            }
            return val;
        }
        return Integer.MAX_VALUE;
    }

    public int findMin() {
        if (!minQueue.isEmpty()) {
            return minQueue.peek();
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {

        MinQueue q = new MinQueue();

        q.enqueue(2);
        q.enqueue(5);

        System.out.println(q.findMin());
        System.out.println(q.dequeue());
        System.out.println(q.findMin());
    }


}
