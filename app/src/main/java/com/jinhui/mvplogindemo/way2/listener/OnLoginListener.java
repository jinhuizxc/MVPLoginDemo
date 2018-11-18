package com.jinhui.mvplogindemo.way2.listener;

import com.jinhui.mvplogindemo.way2.bean.User;

/**
 * Created by jh on 2018/9/25.
 * Email: 1004260403@qq.com
 */
public interface OnLoginListener {

    void success(User user);
    void fail(String msg);

}
