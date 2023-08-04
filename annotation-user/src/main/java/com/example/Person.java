package com.example;

import com.example.annotation.FieldBuilderProperty;

public class Person {


    private int age;
    private String name;
    private Animal animal;

    public int getAge() {
        return age;
    }

    @FieldBuilderProperty(builder = true, randomize = true)
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @FieldBuilderProperty(builder = true)
    public void setName(String name) {
        this.name = name;
    }

    public Animal getAnimal() {
        return animal;
    }
    @FieldBuilderProperty(builder = false, randomize = true)
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", animal=" + animal +
                '}';
    }
}
