package com.keyin.unittestexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AnimalTest {

    @Test
    public void testAnimalCreation() {

        Animal animal = new Animal("Benny",2,"Male");

        List<Animal> animalList = new ArrayList<>();
        animalList.add(animal);

        Assertions.assertTrue(animalList.contains(animal));

    }
}
