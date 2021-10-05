package com.hamad.profiles.ui.login;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.hamad.profiles.data.DataManager;
import com.hamad.profiles.data.model.api.LoginRequest;
import com.hamad.profiles.ui.base.BaseViewModel;
import com.hamad.profiles.utils.CommonUtils;
import com.hamad.profiles.utils.rx.SchedulerProvider;



public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    private static final String TAG = "LoginViewModel";
    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public boolean isUsernameAndPasswordValid(String username, String password) {
        // validate email and password
        if (TextUtils.isEmpty(username)) {
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void login(String username, String password) {
        Log.d(TAG, "login: i'm here");
        setIsLoading(true);
        //CompositeDisposable:
        getCompositeDisposable().add(getDataManager()
                .doLoginAPICall(new LoginRequest.ServerLoginRequest(username, password))
                .doOnSuccess(response -> getDataManager()
                        .updateUserInfo(response.getToken(), DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().openMainActivity();
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public void onServerLoginClick() {
        getNavigator().login();
    }
}
