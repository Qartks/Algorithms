package com.algorithms.qartks;

public class LinkedList {
	
	LinkedListNode head;
	
	public LinkedList() {
		this.head = null;;
	}
	
	public void printList() {
		LinkedListNode current = head;
		
		while(current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public void add(int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		if (head == null) {
			head = newNode;
		} else {
			LinkedListNode current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}
	
	public void printHead() {
		System.out.println("Head : " + head.data);
	}
	
	public LinkedListNode getHead() {
		return this.head;
	}
	
	public void setHead(LinkedListNode h) {
		this.head = h;
	}
}
