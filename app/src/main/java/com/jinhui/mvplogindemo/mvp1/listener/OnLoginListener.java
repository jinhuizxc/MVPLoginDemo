package com.jinhui.mvplogindemo.mvp1.listener;

import com.jinhui.mvplogindemo.mvp1.User;

/**
 * Created by jh on 2018/9/25.
 * Email: 1004260403@qq.com
 */
public interface OnLoginListener {

    void success(User user);
    void fail(String msg);

}
