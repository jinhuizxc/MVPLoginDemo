package com.jinhui.mvplogindemo.way2.mvp.model.login.impl;

import com.jinhui.mvplogindemo.way2.bean.User;
import com.jinhui.mvplogindemo.way2.listener.OnLoginListener;
import com.jinhui.mvplogindemo.way2.mvp.model.login.LoginModel;

/**
 * Created by jh on 2018/9/25.
 * Email: 1004260403@qq.com
 */
public class LoginModelImpl implements LoginModel {


    // 对用户名与密码进行判断
    @Override
    public void login(final String name, final String password, final OnLoginListener loginListener) {
        // 有必要在这里加上一个线程么？
//        Log.e(TAG, "UserPresenterImpl login");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    if(name.equals("zxc") && password.equals("123")){
                        User user = new User();
                        user.setName(name);
                        user.setPassword(password);
                        loginListener.success(user);
                    }else{
                        loginListener.fail("登录失败");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();;
    }
}
