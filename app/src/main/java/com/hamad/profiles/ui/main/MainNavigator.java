package com.hamad.profiles.ui.main;


// here you put the methods that's located in the MainActivity and at the same time
// you want the ViewModel to use it.
public interface MainNavigator {

    void handleError(Throwable throwable);

    void openLoginActivity();
}
