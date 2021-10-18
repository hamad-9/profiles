package com.hamad.profiles.ui.main;


import com.hamad.profiles.data.model.api.ProfileResponse;

import java.util.ArrayList;

// here you put the methods that's located in the MainActivity and at the same time
// you want the ViewModel to use it.
public interface MainNavigator {

    void handleError(Throwable throwable);

    void openLoginActivity();

    void updateList(ArrayList<ProfileResponse> users);

}
