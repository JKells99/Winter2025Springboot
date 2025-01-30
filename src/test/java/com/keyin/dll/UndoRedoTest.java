package com.keyin.dll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UndoRedoTest {

    @Test
    public void testUndoRedoCreate(){
        UndoRedo undoRedo = new UndoRedo();
        undoRedo.addAction("Action 1");
        undoRedo.addAction("Action 2");
        undoRedo.addAction("Action 3");
        System.out.println(undoRedo.getCurrentNode().data);

        Assertions.assertEquals(undoRedo.getCurrentNode().data, "Action 3");

    }

    @Test
    public void testUndoInUndoRedo(){
        UndoRedo undoRedo = new UndoRedo();
        undoRedo.addAction("Action 1");
        undoRedo.addAction("Action 2");
        undoRedo.addAction("Action 3");
        undoRedo.undo();
        Assertions.assertEquals(undoRedo.getCurrentNode().data, "Action 2");
    }

    @Test
    public void testUndoThrowsExceptionWhenTooManyUndos(){
        UndoRedo undoRedo = new UndoRedo();
        undoRedo.addAction("Action 1");
        undoRedo.addAction("Action 2");
        undoRedo.addAction("Action 3");
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> {
            undoRedo.undo();
            undoRedo.undo();
            undoRedo.undo();
            undoRedo.undo();


        });

    }

}
