package com.hamad.profiles.data;

import com.hamad.profiles.data.local.db.DbHelper;
import com.hamad.profiles.data.local.prefs.PreferencesHelper;
import com.hamad.profiles.data.remote.ApiHelper;


public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {
    void setUserAsLoggedOut();

    void updateApiHeader( String accessToken);

    void updateUserInfo(String token,LoggedInMode loggedInMode);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),

        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
