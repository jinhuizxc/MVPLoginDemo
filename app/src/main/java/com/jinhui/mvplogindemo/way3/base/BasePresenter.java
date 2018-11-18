package com.jinhui.mvplogindemo.way3.base;

import android.content.Context;

/**
 * Created by jh on 2018/9/20.
 * Email: 1004260403@qq.com
 */
public class BasePresenter<V, M> {

    public V mView;
    public M mModel;
    public Context mContext;

    public void setVM(V mView, M mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }

}
