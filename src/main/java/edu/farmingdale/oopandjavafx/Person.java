package edu.farmingdale.oopandjavafx;

import javafx.beans.property.*;

public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.age = new SimpleIntegerProperty(age);
    }

    public StringProperty firstNameProperty() { return firstName; }
    public StringProperty lastNameProperty() { return lastName; }
    public IntegerProperty ageProperty() { return age; }
}