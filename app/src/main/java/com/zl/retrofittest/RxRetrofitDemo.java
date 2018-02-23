package com.zl.retrofittest;

import com.zl.retrofittest.bean.DouBanRadioBean;

import retrofit2.http.GET;
import rx.Observable;


public interface RxRetrofitDemo {
    @GET("app/radio/channels")
    Observable<DouBanRadioBean> testRxHttpGet();
}
