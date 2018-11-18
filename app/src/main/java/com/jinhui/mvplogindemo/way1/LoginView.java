package com.jinhui.mvplogindemo.way1;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2018/11/18.
 */
public interface LoginView {

    void loginSuccess(String msg);
    void loginFail(String msg);

    void clearName();

    void clearPassword();

    void showLoading();

    void hideLoading();
}
