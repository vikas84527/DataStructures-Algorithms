package com.learning.dsa._3.linked_list;

public class Problem09_PairwiseSwapNodes {


    //Naive : swapping data
    static void pairwiseSwap(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            curr = curr.next.next;
        }
    }

    //Optimal: swap pointers
    static ListNode pairwiseSwapOptimal(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head.next.next;
        ListNode prev = head;
        head = head.next;
        head.next = prev;
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;
            ListNode next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        }
        prev.next = curr;
        return head;
    }
}
