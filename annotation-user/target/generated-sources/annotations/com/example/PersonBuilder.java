package com.example;

import java.util.Objects;
import com.github.javafaker.Faker;

public class PersonBuilder {

private Person object = new Person();
private Faker faker = new Faker();

    public Person build() {
        return object;
    }

    public PersonBuilder setName(java.lang.String value) {
        object.setName(value);
        return this;
    }
    public PersonBuilder setAge(int value) {
        object.setAge(value);
        return this;
    }

    public PersonBuilder fromObject(Person object) {
        PersonBuilder builder = new PersonBuilder();
        builder.setName(object.getName());
        builder.setAge(object.getAge());
    return builder;
    }

    public PersonBuilder buildNullModel() {
        object.setName(null);
        object.setAge(0);
    return this;
    }

    public PersonBuilder randomize() {
        object.setName(faker.lorem().characters(faker.random().nextInt(5, 15)));
        object.setAge(faker.random().nextInt(5, 15));
    return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonBuilder builder = (PersonBuilder) o;
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
