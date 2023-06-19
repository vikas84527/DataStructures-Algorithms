package com.learning.dsa._3.linked_list;

import java.util.HashMap;


class LRUCache {
    private final HashMap<Integer, DLLNode> map;
    private final int capacity;
    private int count;
    private final DLLNode head;
    private final DLLNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(DLLNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(DLLNode node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            DLLNode node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            System.out.println("Got the value : " + result + " for the key: " + key);
            return result;
        }
        System.out.println("Did not get any value" + " for the key: " + key);
        return -1;
    }

    public void set(int key, int value) {
        System.out.println("Going to set the (key, " + "value) : (" + key + ", " + value + ")");
        if (map.get(key) != null) {
            DLLNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            DLLNode node = new DLLNode(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}

public class Problem11_LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 10);
        cache.set(2, 20);
        cache.set(3, 30);
        System.out.println("Value for the key: 2 is " + cache.get(2));
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " + cache.get(1));
        System.out.println("Value for the key: 3 is " + cache.get(3));
        System.out.println("Value for the key: 4 is " + cache.get(4));
    }
}

