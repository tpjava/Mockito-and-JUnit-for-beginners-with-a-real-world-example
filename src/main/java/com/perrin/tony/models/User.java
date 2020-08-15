package com.perrin.tony.models;

public class User {
    private String firstname;
    private String lastname;
    private int age;

    public User(final String firstname, final String lastname, final int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
}
