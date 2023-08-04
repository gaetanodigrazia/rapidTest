package com.example;

import com.example.annotation.FieldBuilderProperty;

public class Person {
    private int age;
    private String name;
    private Animal animal;
    private String builderFalseRandomizeTrue;

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
    @FieldBuilderProperty(builder = true, randomize = true)
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getBuilderFalseRandomizeTrue() {
        return builderFalseRandomizeTrue;
    }
    @FieldBuilderProperty(randomize = true)
    public void setBuilderFalseRandomizeTrue(String builderFalseRandomizeTrue) {
        this.builderFalseRandomizeTrue = builderFalseRandomizeTrue;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", animal=" + animal +
                ", builderFalseRandomizeTrue='" + builderFalseRandomizeTrue + '\'' +
                '}';
    }
}
