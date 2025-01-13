package com.keyin;



public class PlaceHolder {

    public static void main(String[] args) {

        int a = 1;
        int b = 2;
        int c = a + b;
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";

        System.out.println(YELLOW + "Hello" + RESET);


        System.out.println("The Answer is " + c);
        System.out.println("Hello World!");
    }
}
