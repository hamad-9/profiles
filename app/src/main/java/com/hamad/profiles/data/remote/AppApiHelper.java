package com.hamad.profiles.data.remote;

import com.hamad.profiles.data.model.api.LoginRequest;
import com.hamad.profiles.data.model.api.LoginResponse;
import com.hamad.profiles.data.model.api.LogoutResponse;
import com.hamad.profiles.data.model.api.ProfileResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.List;

import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;



@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }


    @Override
    public Single<LoginResponse> doLoginAPICall(LoginRequest.ServerLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(LogoutResponse.class);
    }

    @Override
    public Single<List<ProfileResponse>> getProfileApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_PROFILE)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectListSingle(ProfileResponse.class);
    }


    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }
}
