package com.learning.dsa._3.linked_list;

public class Problem06_DeleteNodeWithGivenPointer {

    //copy next node data and delete next node
    //will not work for last node
    static void deleteNode(ListNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

}
