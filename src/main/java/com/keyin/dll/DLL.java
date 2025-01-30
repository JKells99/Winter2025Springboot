package com.keyin.dll;

public class DLL {

    private Node head;
    private Node tail;

    public DLL(){
        head = null;
        tail = null;
    }

    public void addLast( String data) {
        // create a temp node
        Node newNode = new Node(data);


        //*
        // If the tail has noting means the list is empty
        // head is now the new node and so is the tail
        // *//
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            //*
            // Set the next value of the tail to be equal to the newNode
            // set the previous value of the new node to point to the tail (set)
            // the tail is now the new node. The tail that we started with is now before the new node
            // *//
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAtBeginning(String data)
    {

        // Create a temp node and pass in the data
        Node temp = new Node(data);
        // if head is null the value of head and tail are now the same. Only 1 node exist
        if (head == null) {
            head = temp;
            tail = temp;
        }
        else {
            // Set the next value from the temp node  to equal the head
            // set the previous value of the head to be equal to the temp
            // the head is tno the temp node (well its values)
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }


    public void addAtPosition( String data, int position) {
        // Set up a temp node
        Node temp = new Node(data);
        //check if position is equal to zero if it is insert at beginning of Linked list
         if(position == 1){
            insertAtBeginning(data);
        }else{
             // Create a current node and set it to be equal to the head
            Node currentNode = head;
            // set current position to be 1
            int currentPosition = 1;

            // set up a while loop to itterate over the list and increse the count for current position
            while(currentNode != null && currentPosition < position){
                currentNode = currentNode.next;
                currentPosition++;
            }

            // if the current node you are trying to add doesnt exist add in the last position of the DLL
            if(currentNode == null){
                addLast(data);
            }else {
                // sets the temp.next to be equal to the current node
                temp.next = currentNode;
                // sets previous value in temp node to be equal to the previous value of the current node
                temp.prev = currentNode.prev;
                // sets the current nodes previous node next value to point to the temp tode
                currentNode.prev.next = temp;
                // sets previous node = to the temp node
                currentNode.prev = temp;

            }
        }
    }



    public void removeLast() {
        if (tail == null) {
            System.out.println("List is empty, nothing to remove.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public Node find(String data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }


    public boolean isEmpty() {
        return head == null;
    }


    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    public Node getFirst() {
        return head;
    }


    public Node getLast() {
        return tail;
    }


}
