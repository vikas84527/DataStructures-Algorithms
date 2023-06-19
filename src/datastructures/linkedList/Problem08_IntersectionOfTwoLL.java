package com.learning.dsa._3.linked_list;

import java.util.HashSet;

public class Problem08_IntersectionOfTwoLL {

    int getIntersection2(ListNode head1, ListNode head2) {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d;
        if (c1 > c2) {
            d = c1 - c2;
            return getIntesectionListNode(d, head1, head2);
        } else {
            d = c2 - c1;
            return getIntesectionListNode(d, head2, head1);
        }
    }

    int getIntesectionListNode(int d, ListNode ListNode1, ListNode ListNode2) {
        int i;
        ListNode current1 = ListNode1;
        ListNode current2 = ListNode2;

        for (i = 0; i < d; i++) {
            if (current1 == null) {
                return -1;
            }
            current1 = current1.next;
        }
        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }

    int getCount(ListNode ListNode) {
        ListNode current = ListNode;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    //UsingHashing
    static int getIntersection(ListNode head1, ListNode head2) {
        HashSet<ListNode> s = new HashSet<>();
        ListNode curr = head1;
        while (curr != null) {
            s.add(curr);
            curr = curr.next;
        }
        curr = head2;
        while (curr != null) {
            if (s.contains(curr))
                return curr.data;
            curr = curr.next;
        }
        return -1;
    }
}
