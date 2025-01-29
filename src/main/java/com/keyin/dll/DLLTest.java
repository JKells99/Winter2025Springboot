package com.keyin.dll;

public class DLLTest {
    public static void main(String[] args) {
       UndoRedo undoRedo = new UndoRedo();

       undoRedo.addAction("Action 1");
       undoRedo.addAction("Action 2");
       undoRedo.addAction("Action 3");
       undoRedo.addAction("Action 4");

       undoRedo.undo();
       undoRedo.undo();
       undoRedo.undo();
       undoRedo.undo();


        undoRedo.displayCurrentState();

    }
}
