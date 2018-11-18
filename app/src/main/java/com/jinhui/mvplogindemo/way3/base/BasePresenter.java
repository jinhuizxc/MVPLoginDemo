package com.jinhui.mvplogindemo.way3.base;

import android.content.Context;

/**
 * Created by jh on 2018/9/20.
 * Email: 1004260403@qq.com
 */
public class BasePresenter<T, M> {

    public T mView;
    public M mModel;
    public Context mContext;

    public void setVM(T mView, M mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }

}
