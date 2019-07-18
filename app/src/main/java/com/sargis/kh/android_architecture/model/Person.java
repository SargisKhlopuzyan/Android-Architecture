package com.sargis.kh.android_architecture.model;

import androidx.annotation.NonNull;

public class Person {

    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(Person person) {
        this.name = person.getName();
        this.surname = person.getSurname();
    }

    public Person() {
        this.name = "";
        this.surname = "";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @NonNull
    @Override
    public String toString() {
        return
                name + " - " + surname;
    }
}
