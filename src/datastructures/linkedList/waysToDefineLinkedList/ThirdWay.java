package datastructures.linkedList.waysToDefineLinkedList;

/* Linked list Node*/
class Node 
{ 
    int data; 
    Node next; 
    Node(int d)  { data = d;  next = null; } 
} 
  
// Linked List class 
class LinkedList3 
{ 
    Node head;  // head of list 
  
    /* Inserts a new Node at front of the list. */
    public void push(int new_data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(new_data); 
  
        /* 3. Make next of new Node as head */
        new_node.next = head; 
  
        /* 4. Move the head to point to new Node */
        head = new_node; 
    } 
  
    public static void main(String[] args) 
    { 
        /* Start with the empty list */
        LinkedList3 llist = new LinkedList3(); 
        llist.push(1); 
        llist.push(3); 
        llist.push(1); 
        llist.push(2); 
        llist.push(1); 
        System.out.println(llist.toString());
    } 
} 