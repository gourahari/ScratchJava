package com.goura.test.featuresinjava8;

import java.util.UUID;

public class Person {

	private final String id;
    private final String name;
    private final int age;
    private final Gender gender;

    private Person(UUID id, String name, Gender gender, int age) {
    	this.id = id.toString();
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d", id, name, gender, age);
    }

    public static Person createPerson(UUID id, String name, Gender gender, int age) {
        return new Person(id, name, gender, age);
    }
}
