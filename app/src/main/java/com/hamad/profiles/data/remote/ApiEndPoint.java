package com.hamad.profiles.data.remote;

import com.hamad.profiles.BuildConfig;



public final class ApiEndPoint {

    public static final String ENDPOINT_LOGIN = BuildConfig.BASE_URL +"/login";
    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL + "/logout";


    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}
