package com.sargis.kh.android_architecture.presenter;

import com.sargis.kh.android_architecture.contract.MVPContract;
import com.sargis.kh.android_architecture.model.Person;

public class MVPPresenter implements MVPContract.Presenter {

    private Person person;
    private MVPContract.View viewCallback;


    public MVPPresenter(MVPContract.View viewCallback) {
        this.person = new Person();
        this.viewCallback = viewCallback;
    }

    @Override
    public void loadMessage() {
        if (person.getFirstName() == null && person.getLastName() == null){
            viewCallback.showError("No person name found.");
            return;
        }

        String message = "Hi " + person.getName() + "!";
        viewCallback.showMessage(message);
    }

    @Override
    public void saveName(String firstName, String lastName) {
        person.setFirstName(firstName);
        person.setLastName(lastName);
    }
}
