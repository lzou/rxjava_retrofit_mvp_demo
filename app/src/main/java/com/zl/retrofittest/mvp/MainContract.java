package com.zl.retrofittest.mvp;

import com.zl.retrofittest.DouBanRadioBean;

/**
 * Created by zoulu on 16/10/20.
 * 主页 契约类
 */

public class MainContract {
    public interface Present extends BasePresenter{
        void getHttpTest();
    }

    public interface View extends BaseView<Present>{
        void getHttpTestSuccess(DouBanRadioBean douBanRadioBean);
    }
}
