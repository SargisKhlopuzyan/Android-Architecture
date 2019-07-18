package com.sargis.kh.android_architecture.viewmodel;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.sargis.kh.android_architecture.model.Person;

public class MVVM_ViewModel extends ViewModel {

    public ObservableArrayList<Person> people;
    private Person person;
    public ObservableField<String> message;


    public void init() {
        people = new ObservableArrayList<>();

        if (person == null)
            person = new Person();

        if (message == null)
            message = new ObservableField<>();
    }

    public void onUpdateClicked(String name, String surname) {
        person.setName(name);
        person.setSurname(surname);
    }

    public void onShowClicked() {
        if (person.getName() == null || person.getSurname() == null || person.getName().isEmpty() || person.getSurname().isEmpty()) {
            message.set("No person name found.");
            return;
        }
        message.set("Hi " + person.getName() + "!");
        people.add(new Person(person));
    }

}