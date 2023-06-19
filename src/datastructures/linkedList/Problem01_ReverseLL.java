package com.learning.dsa._3.linked_list;


import static com.learning.dsa._3.linked_list.LinkedList.printList;

public class Problem01_ReverseLL {
    public static void main(String[] args) {
        ListNode head = LinkedList.getDummyLinkedList1();
//        head = reverseIterative(head);
//        printList(head);
//        head = reverseRec(head, null);
//        printList(head);
        head = reverseInGroupK(head, 3);
        printList(head);

    }

    private static ListNode reverseIterative(ListNode head) {
        ListNode next = null, prev = null, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode reverseRec(ListNode curr, ListNode prev) {
        if (curr == null) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return reverseRec(next, curr);
    }

    //reverse in group of size k
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
            ListNode restHead = reverseInGroupK(next, k);
            head.next = restHead;
        }
        return prev;
    }

}