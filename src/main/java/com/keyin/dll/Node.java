package com.keyin.dll;

public class Node {
    String data;
    Node next;
    Node prev;

    Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;

    }
}
