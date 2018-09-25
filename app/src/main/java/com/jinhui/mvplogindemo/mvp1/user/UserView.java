package com.jinhui.mvplogindemo.mvp1.user;

import com.jinhui.mvplogindemo.mvp1.listener.OnLoginListener; /**
 * Created by jh on 2018/9/25.
 * Email: 1004260403@qq.com
 */
public interface UserView {
    void login(String name, String password, OnLoginListener loginListener);
}
