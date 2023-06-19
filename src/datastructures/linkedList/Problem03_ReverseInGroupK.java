package com.learning.dsa._3.linked_list;

import static com.learning.dsa._3.linked_list.LinkedList.printList;

public class Problem03_ReverseInGroupK {
    public static void main(String[] args) {
        printList(reverseInGroupK(LinkedList.getDummyLinkedList1(), 3));
    }

    private static ListNode reverseInGroupK(ListNode head, int k) {
        ListNode next = null, prev = null, curr = head;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            head.next = reverseInGroupK(next, k);
        }
        return prev;
    }
}
