package test;

import com.example.Person;
import com.example.PersonBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
class PersonBuilderTest {

    @Test
    @DisplayName("buildingTwoDifferentObject")
    void buildingTwoDifferentObject() {
        Person person = new PersonBuilder().randomize().build();
        Person anotherPerson = new PersonBuilder().randomize().build();
        System.out.println(person.toString());
        System.out.println(anotherPerson.toString());

        assertNotEquals(person, anotherPerson);
    }

    @Test
    @DisplayName("buildingObjectDifferingFromOnlyOneField")
    void buildingObjectDifferingFromOnlyOneField() {
        Person person = new PersonBuilder().randomize().build();
        Person anotherPerson = new PersonBuilder().fromObject(person).setAge(11).build();

        System.out.println(person.toString());
        System.out.println(anotherPerson.toString());

        assertEquals(person.getName(), anotherPerson.getName());
        assertEquals(person.getAnimal(), anotherPerson.getAnimal());
        assertNotEquals(person.getAge(), anotherPerson.getAge());
    }

    @Test
    @DisplayName("buildingObjectDifferingFromOnlyOneField")
    void buildingNestedObjectNotNull() {
        Person person = new PersonBuilder().randomize().build();
        Person anotherPerson = new PersonBuilder()
                .fromObject(person).setAge(11).build();

        System.out.println(person.toString());
        System.out.println(anotherPerson.toString());

        assertEquals(person.getName(), anotherPerson.getName());
        assertNotNull(person.getAnimal());
        assertNotNull(anotherPerson.getAnimal());
        assertNotEquals(person.getAge(), anotherPerson.getAge());
    }

}
