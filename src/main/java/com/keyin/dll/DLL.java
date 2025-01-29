package com.keyin.dll;

public class DLL {

    private Node head;
    private Node tail;

    public DLL(){
        head = null;
        tail = null;
    }

    public void addLast( String data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a node to the front of the list
    public void addFirst(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Remove the last node from the list
    public void removeLast() {
        if (tail == null) {
            System.out.println("List is empty, nothing to remove.");
            return;
        }

        if (head == tail) {
            head = tail = null; // Only one element in the list
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Remove the first node from the list
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty, nothing to remove.");
            return;
        }

        if (head == tail) {
            head = tail = null; // Only one element in the list
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Find a node with specific data
    public Node find(String data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return temp;
            }
            temp = temp.next;
        }
        return null; // Return null if data not found
    }

    // Display the list from head to tail
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display the list from tail to head
    public void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Get the size of the list
    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Get the first node
    public Node getFirst() {
        return head;
    }

    // Get the last node
    public Node getLast() {
        return tail;
    }


}
