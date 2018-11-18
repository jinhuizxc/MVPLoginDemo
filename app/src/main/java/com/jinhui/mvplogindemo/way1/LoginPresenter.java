package com.jinhui.mvplogindemo.way1;

import android.os.Handler;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2018/11/18.
 */
public class LoginPresenter {

    private LoginView loginView;
    private Handler handler = new Handler();

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void loginRequest(final String name, final String pass) {
        loginView.showLoading();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (name.equals("zxc") && pass.equals("123")){
                    loginView.loginSuccess("登录成功");
                    loginView.hideLoading();
                }else {
                    loginView.loginFail("登录失败");
                    loginView.hideLoading();
                }

            }
        }, 1000);

    }

    public void clear() {
        loginView.clearName();
        loginView.clearPassword();
    }
}
