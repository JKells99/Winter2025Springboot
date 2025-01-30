package com.keyin.dll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DllTest {

    @Test
    public void testDllCreation(){
        DLL dll = new DLL();
        dll.addAtPosition("Hi",1);
        dll.addAtPosition("Hello",2);
        dll.addAtPosition("World",3);
        Assertions.assertNotNull(dll);

    }

    @Test
    public void testAddAtPosition(){
        DLL dll = new DLL();
        dll.addAtPosition("Hi",1);
        dll.addAtPosition("Hello",2);
        dll.addAtPosition("World",3);
        Assertions.assertEquals("Hi",dll.getFirst().data);
    }

    @Test
    public void testRemoveLast(){
        DLL dll = new DLL();
        dll.addAtPosition("Hi",1);
        dll.addAtPosition("Hello",2);
        dll.addAtPosition("World",3);
        dll.removeLast();
        Assertions.assertEquals("Hello",dll.getLast().data);
    }

    @Test
    public void testIsEmpty(){
        DLL dll = new DLL();
        System.out.println(dll.size());
        Assertions.assertEquals(0, dll.size());
    }


}
