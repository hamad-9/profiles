package com.hamad.profiles.data.remote;

import com.hamad.profiles.data.model.api.LoginRequest;
import com.hamad.profiles.data.model.api.LoginResponse;
import com.hamad.profiles.data.model.api.LogoutResponse;
import com.hamad.profiles.data.model.api.ProfileResponse;

import java.util.List;

import io.reactivex.Single;



public interface ApiHelper {



    Single<LoginResponse> doLoginAPICall(LoginRequest.ServerLoginRequest request);
    Single<LogoutResponse> doLogoutApiCall();
    Single<List<ProfileResponse>> getProfileApiCall();
    ApiHeader getApiHeader();


}
