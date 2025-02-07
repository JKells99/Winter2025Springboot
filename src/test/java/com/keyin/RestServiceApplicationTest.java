package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



public class RestServiceApplicationTest {


   @Test
    public void simpleTest(){
       int a = 1;
       int b = 2;
       Assertions.assertNotEquals(a, b);
   }
}
