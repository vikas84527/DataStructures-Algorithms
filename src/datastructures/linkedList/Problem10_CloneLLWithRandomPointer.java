package com.learning.dsa._3.linked_list;

import java.util.HashMap;

public class Problem10_CloneLLWithRandomPointer {

    //using hashing
    public static ListNode2 clone(ListNode2 head) {

        HashMap<ListNode2, ListNode2> hm = new HashMap<>();
        for (ListNode2 curr = head; curr != null; curr = curr.next)
            hm.put(curr, new ListNode2(curr.data));

        for (ListNode2 curr = head; curr != null; curr = curr.next) {
            ListNode2 clone = hm.get(curr);
            clone.next = hm.get(curr.next);
            clone.random = hm.get(curr.random);
        }
        return hm.get(head);
    }


    public static ListNode2 clone2(ListNode2 head) {
        ListNode2 next, temp;
        for (ListNode2 curr = head; curr != null; ) {
            next = curr.next;
            curr.next = new ListNode2(curr.data);
            curr.next.next = next;
            curr = next;
        }
        for (ListNode2 curr = head; curr != null; curr = curr.next.next) {
            curr.next.random = (curr.random != null) ? (curr.random.next) : null;
        }

        ListNode2 original = head, copy = head.next;

        temp = copy;

        while (original != null && copy != null) {
            original.next = original.next != null ? original.next.next : original.next;

            copy.next = copy.next != null ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }

        return temp;
    }
}
