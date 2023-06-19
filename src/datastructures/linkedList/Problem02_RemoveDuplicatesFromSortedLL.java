package com.learning.dsa._3.linked_list;

import static com.learning.dsa._3.linked_list.LinkedList.insertAtBegin;
import static com.learning.dsa._3.linked_list.LinkedList.printList;

public class Problem02_RemoveDuplicatesFromSortedLL {
    public static void main(String[] args) {
        ListNode head = LinkedList.getDummyLinkedList1();
        printList(head);
        head = insertAtBegin(head, 1);
        printList(head);
        removeDuplicates(head);
        printList(head);

    }

    static void removeDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    static void removeDuplicates2(ListNode head) {
        ListNode temp = head, prev = head;
        while (temp != null) {

            if (temp.data != prev.data) {
                prev.next = temp;
                prev = temp;
            }
            temp = temp.next;
        }
        if (prev != null)
            prev.next = null;
    }
}
