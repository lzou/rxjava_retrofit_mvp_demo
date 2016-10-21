package com.zl.retrofittest;


import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitDemo {
    @GET ("app/radio/channels")
    Call<DouBanRadioBean> testHttpGet();
}
