package com.hamad.profiles.data;

import android.content.Context;

import com.google.gson.Gson;
import com.hamad.profiles.data.local.db.DbHelper;
import com.hamad.profiles.data.local.prefs.PreferencesHelper;
import com.hamad.profiles.data.model.api.LoginRequest;
import com.hamad.profiles.data.model.api.LoginResponse;
import com.hamad.profiles.data.model.api.LogoutResponse;
//import com.hamad.mvvmtemplate.data.model.db.Question;
import com.hamad.profiles.data.model.db.User;
import com.hamad.profiles.data.remote.ApiHeader;
import com.hamad.profiles.data.remote.ApiHelper;

import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final DbHelper mDbHelper;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mGson = gson;
    }

    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return mApiHelper.doLogoutApiCall();
    }


    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }


    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public Single<LoginResponse> doLoginAPICall(LoginRequest.ServerLoginRequest request) {
        return mApiHelper.doLoginAPICall(request);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPreferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPreferencesHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT);
    }

    @Override
    public void updateApiHeader( String accessToken) {
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public void updateUserInfo(String accessToken, LoggedInMode loggedInMode) {
        setAccessToken(accessToken);

        setCurrentUserLoggedInMode(loggedInMode);
        updateApiHeader(accessToken);
    }
}
