package com.algorithms.qartks;

/**
 * Created by qartks on 1/1/17.
 */
public class LLAdd {

    public static void addLists(LinkedListNode node1, LinkedListNode node2, LinkedListNode result)
    {
        if (node1 == null && node2 == null) {
            return;
        }

        if (node1 == null && node2 !=null) {
            result = node2;
            return;
        }

        if (node1 != null && node2 == null) {
            result = node1;
            return;
        }

        int size1 = sizeofList(node1);
        int size2 = sizeofList(node2);
        int carry = 0;

        if (size1 == size2) {
            result = addSameLength(node1, node2, carry);
        } else {
            int diff = Math.abs(size1 - size2);
            if (size1 < size2) {
                swapPointers(node1, node2);
            }
            LinkedListNode curr = node1;
            while (diff != 0) {
                curr = curr.next;
                diff--;
            }

            result = addSameLength(node1, node2, carry);

            addCarryWithList(node1, curr, carry);
        }

        if (carry != 0) {
            add_to_front(node1, carry);
        }

    }

    private static void swapPointers(LinkedListNode node1, LinkedListNode node2) {

    }

    private static void addCarryWithList(LinkedListNode node1, LinkedListNode curr, int carry) {

    }

    private static void add_to_front(LinkedListNode node1, int carry) {
        LinkedListNode n = new LinkedListNode(carry);
        n.next = node1;
        node1 = n;
    }

    private static LinkedListNode addSameLength(LinkedListNode node1, LinkedListNode node2, int carry) {
        return null;
    }

    private static int sizeofList(LinkedListNode node) {
        if (node == null) return 0;
        int result = 1;
        while (node.next!= null) {
            node = node.next;
            result++;
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
