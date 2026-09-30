package com.phrolova.algorithm.hot100.common;

/**
 * Node with a random pointer, used by Copy List with Random Pointer.
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
