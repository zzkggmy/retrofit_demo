package com.zoro.retrofitdemo.ui.login;

import android.util.Log;
import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zoro.request_utils.api.RequestUtil;
import com.zoro.request_utils.request_service.ApiServices;
import com.zoro.request_utils.response.UserInfoRes;
import com.zoro.request_utils.utils.EncryptUtils;
import com.zoro.retrofitdemo.R;
import com.zoro.retrofitdemo.data.LoginRepository;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        // can be launched in a separate asynchronous job
//        Result<LoggedInUser> result = loginRepository.login(username, password);
//
//        if (result instanceof Result.Success) {
//            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
//            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
//        } else {
//            loginResult.setValue(new LoginResult(R.string.login_failed));
//        }
        Map<String, String> field = new HashMap<>();
        field.put("account", username);
        field.put("password", EncryptUtils.encryptMD5ToString(password).toLowerCase());
        field.put("hash", EncryptUtils.encryptMD5ToString("HASH".concat(username).concat("1230")).toLowerCase());

        RequestUtil
                .getInstance()
                .create(ApiServices.class)
                .login(field)
                .enqueue(new Callback<UserInfoRes>() {
                    @Override
                    public void onResponse(Call<UserInfoRes> call, Response<UserInfoRes> response) {
                        Log.d("loginnn", username + "   " + password + "  response  " + response.body().getData().getUserinfo().getNickname());
                    }

                    @Override
                    public void onFailure(Call<UserInfoRes> call, Throwable t) {
                        Log.d("loginnn", t.toString());
                    }
                });
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}