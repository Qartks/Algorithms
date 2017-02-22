package com.algorithms.qartks;

import java.util.Stack;

/**
 * Created by qartks on 2/22/17.
 */
public class MinStack extends Stack<Integer> {

    Stack<Integer> m;
    /** initialize your data structure here. */
    public MinStack() {
        m = new Stack<>();
    }

    public void push(int x) {
        super.push(x);
        if (getMin() > x) {
            m.push(x);
        }
    }

    public Integer pop() {
        int item = super.pop();
        if (item == getMin()) {

        }
        return item;
    }

    public Integer top() {
        Integer item = super.peek();
        return item;
    }

    public int getMin() {
        if (!m.isEmpty())
            return m.peek();

        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.pop();
    }
}
