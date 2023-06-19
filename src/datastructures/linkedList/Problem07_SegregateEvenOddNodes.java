package com.learning.dsa._3.linked_list;

public class Problem07_SegregateEvenOddNodes {

    static ListNode segregateOddEven(ListNode head) {

        ListNode evenStart = null, evenEnd = null;
        ListNode oddStart = null, oddEnd = null;

        for (ListNode curr = head; curr != null; curr = curr.next) {
            int currData = curr.data;
            if (currData % 2 == 0) {
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            }
        }
        if (oddStart == null || evenStart == null) {
            return head;
        }
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }
}
