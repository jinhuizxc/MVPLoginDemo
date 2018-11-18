package com.jinhui.mvplogindemo.way2.mvp.presenter;

import android.os.Handler;

import com.jinhui.mvplogindemo.way2.mvp.view.LoginView;
import com.jinhui.mvplogindemo.way2.bean.User;
import com.jinhui.mvplogindemo.way2.listener.OnLoginListener;
import com.jinhui.mvplogindemo.way2.mvp.model.login.impl.LoginModelImpl;
import com.jinhui.mvplogindemo.way2.mvp.model.login.LoginModel;

/**
 * Created by jh on 2018/9/25.
 * Email: 1004260403@qq.com
 */
public class LoginPresenter {

    private Handler handler = new Handler();

    LoginView loginView;

    LoginModel loginModel;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModelImpl();
    }

    public void login() {
        // 显示进度条
        loginView.showLoading();
        //加载进度条属于耗时操作
        //想要显示登录成功与失败的方法在有结果后给于反馈！这个login指向UserBizImpl中的方法
        loginModel.login(loginView.getName(), loginView.getPassword(), new OnLoginListener() {
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
