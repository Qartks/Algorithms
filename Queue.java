package com.algorithms.qartks;

public class Queue {
	
	QueueNode top;
	
	public Queue() {
		this.top = null;
	}
	
	public void push(int d) {
		QueueNode node = new QueueNode(d);
		
		if (top == null) {
			top = node;
		} else {
			QueueNode curr = top;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = node;
		}
	}

	public int pop() {
		int data = Integer.MIN_VALUE;
		
		return data;
	}

	public void peek() {
		if (top != null) {
			System.out.println(top.data);
		} else {
			System.err.println("Queue Empty, Can not peek");
		}
	}

	public void print() {
		QueueNode curr = this.top;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	
}
