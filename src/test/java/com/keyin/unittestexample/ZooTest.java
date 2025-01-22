package com.keyin.unittestexample;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZooTest {

    @Test
    public void testAddingAnimalToZoo() {
        Zoo zoo = new Zoo();
        Animal animal = new Animal("Jimmy",3,"Male");
        zoo.addAnimalToZoo(animal);
        Assertions.assertEquals(zoo.getAnimals().size(), 1);
    }

    @Test
    public void testRemovingAnimalFromZoo() {
        Zoo zoo = new Zoo();
        Animal animal = new Animal("Jimmy",3,"Male");
        zoo.addAnimalToZoo(animal);
        zoo.removeAnimalFromZoo(animal);
        Assertions.assertEquals(zoo.getAnimals().size(), 0);

    }

    @Test
    public void testCreatingZooWithName(){
        Zoo zoo = new Zoo("St John's");
        Assertions.assertEquals("St John's", zoo.getZooName());
    }

    @Test
    public void testAddingAnimalToZooWithExistingAnimal(){
        Zoo zoo = new Zoo("St John's");
        Animal animal = new Animal("Jimmy",3,"Male");
        zoo.addAnimalToZoo(animal);
        Animal animal2 = new Animal("Jimmy The Lion",5,"Male");
        zoo.addAnimalToZoo(animal2);
        Assertions.assertEquals(zoo.getAnimals().size(), 2);

    }
}
