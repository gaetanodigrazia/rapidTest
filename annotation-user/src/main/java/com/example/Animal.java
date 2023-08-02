package com.example;

import com.example.annotation.FieldBuilderProperty;

public class Animal {


    private int first;
    private String second;

    public int getFirst() {
        return first;
    }

    @FieldBuilderProperty
    public void setFirst(int first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    @FieldBuilderProperty
    public void setSecond(String second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "first=" + first +
                ", second='" + second + '\'' +
                '}';
    }
}
