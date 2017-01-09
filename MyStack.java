package com.algorithms.qartks;

public class MyStack {
	
	StackNode top;
	
	public MyStack() {
		this.top = null;
	}

	public void push(int d) {
		StackNode node = new StackNode(d);
		if (top == null) {
			top = node;
		} else {
			node.next = this.top;
			this.top = node;
		}
	}

	public int pop() {
		int data = Integer.MIN_VALUE;
		if (top != null) {
			data = this.top.data;
			this.top = this.top.next;
		} else {
			System.err.println("Stack Empty");
		}
		
		return data;
	}

	public void peek() {
		if (top != null) {
			System.out.println(top.data);
		} else {
			System.err.println("Stack Empty, Can not peek");
		}
	}

	public void print() {
		StackNode curr = this.top;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}

}
