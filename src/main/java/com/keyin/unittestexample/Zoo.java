package com.keyin.unittestexample;


import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private String zooName;
    List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }



    public Zoo(String zooName) {
        this.zooName = zooName;
        this.animals = new ArrayList<>();
    }

    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        this.zooName = zooName;
    }



    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimalToZoo(Animal animal) {
        animals.add(animal);
    }
    public void removeAnimalFromZoo(Animal animal) {
        animals.remove(animal);
    }
}
