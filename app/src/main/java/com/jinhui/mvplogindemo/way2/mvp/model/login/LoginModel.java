package com.jinhui.mvplogindemo.way2.mvp.model.login;

import com.jinhui.mvplogindemo.way2.listener.OnLoginListener; /**
 * Created by jh on 2018/9/25.
 * Email: 1004260403@qq.com
 */
public interface LoginModel {
    void login(String name, String password, OnLoginListener loginListener);
}
