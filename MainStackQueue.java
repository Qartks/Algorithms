package com.algorithms.qartks;

public class MainStackQueue {

	public static void main(String[] args) {
//		Stack s = new Stack();
//		
//		s.push(20);
//		s.push(30);
//		s.push(40);
//		s.push(50);
//		s.push(60);
//		
//		s.pop();
//		
//		s.print();
		
		MyQueue q = new MyQueue();
		
		q.push(20);
		q.push(30);
		q.push(40);
		q.push(50);
		q.push(60);
		
		q.peek();
		q.print();
	}

}
