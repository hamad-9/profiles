package com.hamad.profiles.data.remote;

import com.hamad.profiles.data.model.api.LoginRequest;
import com.hamad.profiles.data.model.api.LoginResponse;
import com.hamad.profiles.data.model.api.LogoutResponse;

import io.reactivex.Single;



public interface ApiHelper {



    Single<LoginResponse> doLoginAPICall(LoginRequest.ServerLoginRequest request);
    Single<LogoutResponse> doLogoutApiCall();

    ApiHeader getApiHeader();


}
