package com.learning.dsa._3.linked_list;

public class LinkedList {

    static ListNode head;

    static ListNode getDummyLinkedList1() {
        LinkedList list = new LinkedList();
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(5);
        list.head.next.next.next.next.next = new ListNode(6);
        list.head.next.next.next.next.next.next = new ListNode(7);
        return list.head;

    }

    public static ListNode insertAtBegin(ListNode head, int data) {
        ListNode temp = new ListNode(data);
        temp.next = head;
        return temp;

    }

    public static void insertAtEnd(int data) {
        ListNode temp = new ListNode(data);
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
    }

    public static int searchIterative(ListNode head, int data) {
        ListNode curr = head;
        int pos = 1;
        while (curr != null) {
            if (curr.data == data) {
                return pos;
            } else {
                pos++;
                curr = curr.next;
            }
        }
        return -1;
    }

    public static int searchRec(ListNode head, int data) {
        if (head == null) {
            return -1;
        }
        if (head.data == data) {
            return 1;
        } else {
            int res = searchRec(head.next, data);
            if (res == -1) return -1;
            else return (res + 1);
        }

    }

    public static ListNode insertAtGivenPos(ListNode head, int data, int pos) {
        ListNode temp = new ListNode(data);
        if (pos == 1) {
            temp.next = head;
            return temp;
        }
        ListNode curr = head;

        for (int i = 0; i < pos - 2 && curr != null; i++) {
            curr = curr.next;
        }
        if (curr == null) {
            return head;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    public static void deleteFrontNode(ListNode head) {
        if (head == null) return;
        if (head.next == null) head = null;
        head = head.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void printRec(ListNode head) {
        if (head == null) {
            System.out.print("null");
            return;
        }
        System.out.print(head.data + "->");
        printRec(head.next);
    }

    public static void main(String[] args) {
        LinkedList.head = getDummyLinkedList1();
        printRec(head);
    }
}

class DLLNode {
    int key;
    int value;
    DLLNode pre;
    DLLNode next;

    public DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

//ListNode with random pointer
class ListNode2 {
    int data;
    ListNode2 next;
    ListNode2 random;

    public ListNode2(int data) {
        this.data = data;
    }
}