package com.learning.dsa._3.linked_list;

public class Problem12_MergeTwoSortedLL {

    static ListNode sortedMerge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode head = null, tail = null;
        if (a.data <= b.data) {
            head = tail = a;
            a = a.next;
        } else {
            head = tail = b;
            b = b.next;
        }
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                tail = a;
                a = a.next;
            } else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }
        return head;
    }
}
