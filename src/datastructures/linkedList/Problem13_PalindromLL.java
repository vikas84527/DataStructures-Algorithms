package com.learning.dsa._3.linked_list;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem13_PalindromLL {

    //Optimal
    static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverseList(slow.next, null);
        ListNode curr = head;
        while (rev != null) {
            if (rev.data != curr.data)
                return false;
            rev = rev.next;
            curr = curr.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode curr, ListNode prev) {
        if (curr == null) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return reverseList(next, curr);
    }

    //Using Stack
    static boolean isPalindrome2(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (ListNode curr = head; curr != null; curr = curr.next)
            stack.push(curr.data);
        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (stack.pop() != curr.data)
                return false;
        }
        return true;
    }
}
