package com.jinhui.mvplogindemo.way3.login;

import android.os.Handler;

/**
 * Created by jh on 2018/9/20.
 * Email: 1004260403@qq.com
 */
public class LoginPresenter extends LoginContract.Presenter{

    private Handler handler = new Handler();

    public void login(String loginName, String loginPassWord) {

        mModel.getList();
//        mView.showLoading();
//        if (loginName.equals("zxc") && loginPassWord.equals("123")){
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    mView.hideLoading();
//                    mView.showMsg("登录成功");
//                }
//            }, 2000);
//        }else {
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    mView.hideLoading();
//                    mView.showErrorMsg("用户名或者密码错误");
//
//                }
//            }, 2000);
//        }
    }

    public void clear() {
        mView.clearName();
        mView.clearPassword();
    }
}
