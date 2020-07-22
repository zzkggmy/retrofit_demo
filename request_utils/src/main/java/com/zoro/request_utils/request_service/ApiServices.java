package com.zoro.request_utils.request_service;

import com.zoro.request_utils.response.UserInfoRes;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("indoor/v1/app/login")
    Call<UserInfoRes> login(@Body Map<String, String> field);
}
