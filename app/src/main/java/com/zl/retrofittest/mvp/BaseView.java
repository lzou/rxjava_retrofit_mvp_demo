package com.zl.retrofittest.mvp;

/**
 * Created by zoulu on 16/5/24.
 * mvp baseview
 */
public interface BaseView<T> {
    void setPresenter(T presenter);
}
