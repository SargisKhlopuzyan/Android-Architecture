package com.sargis.kh.android_architecture.contract;

/** Helps us track the relationship between the View and the Presenter in a central place */
public interface MVPContract {

    /** Represents the View in MVP. */
    interface View {
        void showMessage(String message);
        void showError(String error);
    }

    /** Represents the Presenter in MVP. */
    interface Presenter {
        void loadMessage();
        void saveName(String firstName, String lastName);
    }

}
