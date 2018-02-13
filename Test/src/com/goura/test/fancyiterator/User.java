package com.goura.test.fancyiterator;

import java.util.UUID;

public class User {

    private final String name;
    private final String id;
    private final int age;
    private final Gender gender;
    private final String email;

    public User(String name, int age, Gender gender, String email) {
        this.id = UUID.fromString(email).toString();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
