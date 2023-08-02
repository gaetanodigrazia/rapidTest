package com.example;

import java.util.Objects;
import com.github.javafaker.Faker;

public class AnimalBuilder {

private Animal object = new Animal();
private Faker faker = new Faker();

    public Animal build() {
        return object;
    }

    public AnimalBuilder setSecond(java.lang.String value) {
        object.setSecond(value);
        return this;
    }
    public AnimalBuilder setFirst(int value) {
        object.setFirst(value);
        return this;
    }

    public AnimalBuilder fromObject(Animal object) {
        AnimalBuilder builder = new AnimalBuilder();
        builder.setSecond(object.getSecond());
        builder.setFirst(object.getFirst());
    return builder;
    }

    public AnimalBuilder buildNullModel() {
        object.setSecond(null);
        object.setFirst(0);
    return this;
    }

    public AnimalBuilder randomize() {
        object.setSecond(faker.lorem().characters(faker.random().nextInt(5, 15)));
        object.setFirst(faker.random().nextInt(5, 15));
    return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalBuilder builder = (AnimalBuilder) o;
        return Objects.equals(object, builder.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object);
    }

    @Override
    public String toString() {
    return "Builder{" +
        "object=" + object +
        '}';
    }
}
