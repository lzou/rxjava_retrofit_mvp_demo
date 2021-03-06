package com.zl.retrofittest;

import com.zl.retrofittest.bean.DouBanRadioBean;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zoulu on 16/10/20.
 * 封装retrofit
 */

public class HttpHelper {
    private static final String BASE_URL = "https://www.douban.com/j/";

    private static final int DEFAULT_TIMEOUT = 15;

    private Retrofit retrofit;

    //构造方法私有
    private HttpHelper() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

    }

    //在访问HttpHelper时创建单例
    private static class SingletonHolder{
        private static final HttpHelper INSTANCE = new HttpHelper();
    }

    //获取单例
    public static HttpHelper getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * @param subscriber 由调用者传过来的观察者对象
     */
    public void getTopMovie(Subscriber<DouBanRadioBean> subscriber){
        RxRetrofitDemo rxRetrofitDemo = retrofit.create(RxRetrofitDemo.class);
        rxRetrofitDemo.testRxHttpGet()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
