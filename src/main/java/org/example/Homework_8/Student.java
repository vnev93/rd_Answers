package org.example.Homework_8;

import java.util.UUID;

public class Student {
    private final String id;
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" + "ID='" + id + '\'' + ",First Name'" + firstName + '\'' + ", Last Name='" + lastName + '\'' + '}';
    }
}
