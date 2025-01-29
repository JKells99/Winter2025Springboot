package com.keyin.dll;

public class UndoRedo {

   private DLL history;
   private Node currentNode;

   public UndoRedo() {
       history = new DLL();
       currentNode = null;
   }

   public void addAction(String action){
       history.addLast(action);
       currentNode = history.getLast();

   }

   public String undo(){
       if(currentNode == null || currentNode.prev ==null){
           System.out.println("No Node To Undo");
           throw  new RuntimeException("No previous node");


       }
       currentNode = currentNode.prev;
       return currentNode.data;


   }

   public String redo(){
       if(currentNode == null || currentNode.next==null){
           System.out.println("Nothing to redo");
           return null;
       }
       currentNode = currentNode.next;
       return currentNode.data;
   }


   public void displayHistory(){
       history.displayForward();
   }

    public void displayCurrentState() {
        if (currentNode != null) {
            System.out.println("Current action: " + currentNode.data);
        } else {
            System.out.println("No actions in history.");
        }
    }



}
