package com.keyin.dll;

public class UndoRedo {


    /*
     Initilize a new DLL and a current node
     */

   private DLL history;
   private Node currentNode;

   // Set up constructor for the class where it will create a new DLL on each instance of the class
    // set the current node to be null
   public UndoRedo() {
       history = new DLL();
       currentNode = null;
   }

   // adding an action will just add to the end
    // then we set the current node to be the last element of the DLL
   public void addAction(String action){
       history.addLast(action);
       currentNode = history.getLast();

   }


    //**
    // *
    // We do a check to see if the current node is null
    // if it is null we can just throw a exception
    // else we will set the current node to be the previous value of the current node
    //
    //
    // *//
   public String undo(){
       if(currentNode == null){
           System.out.println("No Node To Undo");
           throw  new RuntimeException("No previous node");


       }
       currentNode = currentNode.prev;
       return currentNode.data;


   }


    /*
    For redo it is pretty much the opposite of undo
    we check to see if current node is null if it is we can throw an exception/ print an error and then return null
    else we can set the current node reference to the next value of the current node

     */
   public String redo(){
       if(currentNode == null || currentNode.next==null){
           throw new RuntimeException("No Node To Redo");

       }
       currentNode = currentNode.next;
       return currentNode.data;
   }


   /*
   this will just print the list in its entirety
    */
   public void displayHistory(){
       history.displayForward();
   }

   /*
   this will display the current state we are in the DLL based of the current node and its data
    */
    public void displayCurrentState() {
        if (currentNode != null) {
            System.out.println("Current action: " + currentNode.data);
        } else {
            System.out.println("No actions in history.");
        }
    }

    public Node getCurrentNode() {
        return currentNode;
    }
}
