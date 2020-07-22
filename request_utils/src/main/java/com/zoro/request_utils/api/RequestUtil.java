package com.zoro.request_utils.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestUtil {

    private final int READ_TIME_OUT = 3000;
    private final int WRITE_TIME_OUT = 3000;
    private final int CONNECT_TIME_OUT = 3000;

    private final String base_url = "http://rfs.test.rcx.wonlap.cn/";

    private Retrofit retrofit;

    private static RequestUtil instance;

    public static RequestUtil getInstance() {
        if (instance == null)
            synchronized (RequestUtil.class) {
                if (instance == null)
                    instance = new RequestUtil();
            }

        return instance;
    }

    public void init() {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(new LoggingInterceptor())//自定义拦截器
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
                .build();

        retrofit = new Retrofit
                .Builder()
                .baseUrl(base_url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }

    public <T> void request(Call<T> call, CallBack<T> callBack) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (callBack != null)
                    callBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (callBack != null)
                    callBack.onError(t);
            }
        });
    }

    public <T> T create(Class<T> clazz) {
        return retrofit.create(clazz);
    }

    public interface CallBack<T> {
        void onResponse(T responseBody);

        void onError(Throwable throwable);
    }


}
