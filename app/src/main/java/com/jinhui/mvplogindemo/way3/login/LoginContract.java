package com.jinhui.mvplogindemo.way3.login;


import com.jinhui.mvplogindemo.way3.base.BaseModel;
import com.jinhui.mvplogindemo.way3.base.BasePresenter;
import com.jinhui.mvplogindemo.way3.base.BaseView;

/**
 * Created by jh on 2018/9/20.
 * Email: 1004260403@qq.com
 */
public interface LoginContract {

    public interface View extends BaseView {

        void showMsg(String str);

        void clearName();

        void clearPassword();

        void showLoading();

        void hideLoading();

        void showErrorMsg(String str);
    }

    public interface Model extends BaseModel {

    }

    public class Presenter extends BasePresenter<View, Model> {

    }


}
