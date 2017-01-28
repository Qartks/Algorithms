package com.algorithms.qartks;

import java.util.Arrays;
import java.util.List;

public class MainLinkList {
	
	public static int nthToLastRecursive (LinkedListNode n, int k) {
		if (n == null) {
			return 0;
		}
		
		int i = nthToLastRecursive(n.next, k) + 1;
		if (i == k) {
			System.out.println(n.data);
		}
		
		return i;
	}
	
	public static void nthToLastIterative(LinkedListNode n, int k) {
		if (n == null) return;
		
		LinkedListNode current = n;
		LinkedListNode runner = n;
		int i = k;
		while (i != 0) {
			if (runner == null) return;
			runner = runner.next;
			i--;
		}
		while (runner != null) {
			runner = runner.next;
			current = current.next;
		}
		
		System.out.println(current.data);
	}
	
	public static LinkedListNode rotateListByK (LinkedListNode head, int k) {
		if (head == null) {
			return head;
		}
		int n = 1;
		LinkedListNode tail = head;
		
		while(tail.next != null) {
			++n;
			tail = tail.next;
		}
		
		tail.next = head;
		k %= n;
		
		if (k % n == 0) {
			return head;
		}
		
		LinkedListNode newTail = tail;
		int steps = n - k;
		while(steps-- > 0) {
			newTail = newTail.next;
		}
		
		LinkedListNode newHead = newTail.next;
		newTail.next = null;
		
		return newHead;
	}
	
	public static LinkedListNode evenOddBad (LinkedListNode head) {
		if ( head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode even = head;
		LinkedListNode odd = head.next;
		LinkedListNode oddHead = odd;
		LinkedListNode evenHead = even;
		LinkedListNode current = odd;
		int i = 1;
		
		while (current.next != null) {
			i++;
			if (i % 2 == 0) {
				even.next = current.next;
				even = even.next;
			} else {
				odd.next = current.next;
				odd = odd.next;
			}
			current = current.next;
		}
		
		even.next = oddHead;
		odd.next = null;
		
		return evenHead;
		
	}
	
	public static LinkedListNode evenOddMerge(LinkedListNode head) {
		if ( head == null) {
			return head;
		}
		
		LinkedListNode evenHead = new LinkedListNode();	
		LinkedListNode oddHead = new LinkedListNode();
		
		List<LinkedListNode> tails = Arrays.asList(evenHead, oddHead);
		int turn = 1;
		
		for (LinkedListNode iter = head; iter!= null; iter = iter.next) {
			tails.get(turn).next = iter;
			tails.set(turn, tails.get(turn).next);
			turn ^= 1;
		}
		
		tails.get(1).next = null;
		tails.get(0).next = oddHead.next;
		
		return evenHead.next;
		
	}
	
	public static LinkedListNode pivotAroundK(LinkedListNode head, int k) {
		if (head == null) {
			return head;
		}
		LinkedListNode lessHead = new LinkedListNode();
		LinkedListNode equalHead = new LinkedListNode();
		LinkedListNode greaterHead = new LinkedListNode();

		LinkedListNode lessIter = lessHead;
		LinkedListNode equalIter = equalHead;
		LinkedListNode greaterIter = greaterHead;
		
		LinkedListNode iter = head;
		
		while (iter != null) {
			if (iter.data < k) {
				lessIter.next = iter;
				lessIter = iter;
			} else if (iter.data == k) {
				equalIter.next = iter;
				equalIter = iter;
			} else {
				greaterIter.next = iter;
				greaterIter = iter;
			}
			iter = iter.next;
		}
		
		lessIter.next = equalHead.next;
		equalIter.next = greaterHead.next;
		greaterIter.next = null;
		
		return lessHead.next;
	}
	
	
	public static void printMiddle (LinkedListNode head) {
		if (head == null) {
			return;
		}
		
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		while (fast != null && fast.next!= null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast == null) {
			System.out.println(slow.data);
		} else {
			System.out.println(slow.data);
		}
	}

	public LinkedListNode merge(LinkedListNode node1, LinkedListNode node2) {
		if (node1 == null)
			return node2;

		if (node2 == null)
			return node1;

		LinkedListNode result;

//		if (node1.data < node2.data) {
//		}
		return null;
	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.printList();
		
		MyLinkedList list2 = new MyLinkedList();
		list2.add(6);
		list2.add(2);
		list2.add(3);
		list2.add(8);
		list2.add(9);
		list2.add(5);
		list2.add(1);
		list2.add(5);
		list2.add(4);
		list2.add(10);
		list2.printList();
		
		MyLinkedList listOne = new MyLinkedList();
		listOne.add(11);
		
		MyLinkedList listNull = new MyLinkedList();
		
		System.out.println("\nResult: \n");
//		list.printHead();
		
//		nthToLastRecursive(list.getHead(), 3);
//		nthToLastIterative(list.getHead(), 3);
		
//		list.setHead(rotateListByK(list.getHead(), 2));
//		list.printList();
		
//		list.setHead(evenOddBad(list.getHead()));
//		list.printList();
		
//		list.setHead(evenOddMerge(list.getHead()));
//		list.printList();
		
//		printMiddle(list.getHead());
		
		list2.setHead(pivotAroundK(list2.getHead(), 5));
		list2.printList();
	}

}
