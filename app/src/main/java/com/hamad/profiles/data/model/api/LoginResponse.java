package com.hamad.profiles.data.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class LoginResponse {
    @SerializedName("token")
    private String token;
    public String getToken() {
        return token;
    }
    @Override
    public String toString() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginResponse that = (LoginResponse) o;
        return Objects.equals(token, that.token);
    }
    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
