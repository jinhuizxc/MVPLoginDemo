package com.jinhui.mvplogindemo.mvp1;

import com.jinhui.mvplogindemo.mvp1.listener.OnLoginListener; /**
 * Created by jh on 2018/9/25.
 * Email: 1004260403@qq.com
 */
public interface LoginView {

    void showLoading();
    void hideLoading();

    void showSuccessMsg(User user);

    void showErrorMsg(String msg);

    String getName();
    String getPassword();



    void clearName();
    void clearPassword();
}
