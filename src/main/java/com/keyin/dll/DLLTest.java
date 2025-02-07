package com.keyin.dll;

public class DLLTest {
    public static void main(String[] args) {
       UndoRedo undoRedo = new UndoRedo();

       undoRedo.addAction("Action 1");
       undoRedo.addAction("Action 2");
       undoRedo.addAction("Action 3");
       undoRedo.addAction("Action 4");

       undoRedo.undo();





        undoRedo.displayCurrentState();

//        DLL dll = new DLL();
//        dll.addAtPosition("Hello",1);
//        dll.addAtPosition("World",2);
//        dll.addAtPosition("This",3);
//        dll.addAtPosition("World",4);
//        dll.addAtPosition("Geoff",1);
//
//
//
//        dll.displayForward();






    }
}
