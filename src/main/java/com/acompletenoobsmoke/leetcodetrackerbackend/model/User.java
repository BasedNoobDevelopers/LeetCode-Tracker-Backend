package com.acompletenoobsmoke.leetcodetrackerbackend.model;

public class User {

    public Long id;
    public String firstName;
    public String lastName;
    public String programmingLanguage;

    public User() {}

    public User(Long id, String firstName, String lastName, String programmingLanguage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.programmingLanguage = programmingLanguage;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                '}';
    }
}
