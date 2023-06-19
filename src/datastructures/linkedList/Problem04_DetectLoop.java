package com.learning.dsa._3.linked_list;

import java.util.HashSet;

public class Problem04_DetectLoop {


    //Optimal: using floyd cycle detection

    static boolean detectLoop(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    //destroys LinkedList
    static boolean isLoop(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode curr = head;
        while (curr != null) {
            if (curr.next == null)
                return false;
            if (curr.next == temp)
                return true;
            ListNode curr_next = curr.next;
            curr.next = temp;
            curr = curr_next;
        }
        return false;
    }

    //Using Hashing
    static boolean isLoop2(ListNode head) {
        HashSet<ListNode> s = new HashSet<ListNode>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (s.contains(curr))
                return true;
            s.add(curr);
        }
        return false;
    }


}
