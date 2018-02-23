package com.zl.retrofittest.mvp;


import com.zl.retrofittest.bean.DouBanRadioBean;
import com.zl.retrofittest.HttpHelper;

import rx.Subscriber;

public class MainPresenter implements MainContract.Present{
    private MainContract.View view;

    public MainPresenter(MainContract.View view){
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void getHttpTest() {
        HttpHelper.getInstance().getTopMovie(new Subscriber<DouBanRadioBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DouBanRadioBean douBanRadioBean) {
                view.getHttpTestSuccess(douBanRadioBean);
            }
        });
    }

    @Override
    public void start() {
        getHttpTest();
    }
}
