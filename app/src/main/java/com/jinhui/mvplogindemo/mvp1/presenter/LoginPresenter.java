package com.jinhui.mvplogindemo.mvp1.presenter;

import android.os.Handler;
import android.util.Log;

import com.jinhui.mvplogindemo.mvp1.LoginActivity;
import com.jinhui.mvplogindemo.mvp1.LoginView;
import com.jinhui.mvplogindemo.mvp1.User;
import com.jinhui.mvplogindemo.mvp1.listener.OnLoginListener;
import com.jinhui.mvplogindemo.mvp1.presenter.impl.LoginPresenterImpl;
import com.jinhui.mvplogindemo.mvp1.user.UserView;

/**
 * Created by jh on 2018/9/25.
 * Email: 1004260403@qq.com
 */
public class LoginPresenter {

    private Handler handler = new Handler();
    LoginView loginView;

    UserView userView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        userView = new LoginPresenterImpl();
    }

    public void login() {
        // 显示进度条
        loginView.showLoading();
        //加载进度条属于耗时操作
        //想要显示登录成功与失败的方法在有结果后给于反馈！这个login指向UserBizImpl中的方法
        userView.login(loginView.getName(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void success(final User user) {
//                Log.e(TAG, "UserPresenter login");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showSuccessMsg(user);
                        loginView.hideLoading();
                    }
                });
            }
            @Override
            public void fail(final String msg) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showErrorMsg(msg);
                        loginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        loginView.clearName();
        loginView.clearPassword();
    }
}
