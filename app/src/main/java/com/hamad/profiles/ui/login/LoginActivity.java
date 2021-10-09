package com.hamad.profiles.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.hamad.profiles.BR;
import com.hamad.profiles.R;
import com.hamad.profiles.databinding.ActivityLoginBinding;
import com.hamad.profiles.di.component.ActivityComponent;
import com.hamad.profiles.ui.base.BaseActivity;
import com.hamad.profiles.ui.main.MainActivity;

import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.Scanner;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {

    private ActivityLoginBinding mActivityLoginBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle the error when you send a request
        ANError error = (ANError) throwable;
//        Scanner scanner = new Scanner(error.getErrorBody());
//        JSONObject jsonObject = scanner.
//        String stringError  = error.toString();
//        String stringError2  = error.getErrorBody();
//        String stringError3  = error.getErrorDetail();
        String stringError4 = error.getErrorBody().substring(12, error.getErrorBody().length()-2);
//        Log.e("aomari", stringError4);
        Toast.makeText(this, stringError4,Toast.LENGTH_LONG).show();
    }

    @Override
    public void login() {
        String email = mActivityLoginBinding.etEmail.getText().toString();
        String password = mActivityLoginBinding.etPassword.getText().toString();
        if (mViewModel.isUsernameAndPasswordValid(email, password)) {
            hideKeyboard();
            mViewModel.login(email, password);
        } else {
            Toast.makeText(this, getString(R.string.invalid_email_password), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mViewModel.setNavigator(this);
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }
}
