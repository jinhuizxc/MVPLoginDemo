package com.jinhui.mvplogindemo.mvp2.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jinhui.mvplogindemo.R;
import com.jinhui.mvplogindemo.mvp2.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jh on 2018/9/25.
 * Email: 1004260403@qq.com
 */
public class LoginActivity1 extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {


    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_clear)
    Button btClear;
    @BindView(R.id.pb)
    ProgressBar pb;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }


    @Override
    public void showMsg(String str) {
        Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearName() {
        etName.setText("");
    }

    @Override
    public void clearPassword() {
        etPassword.setText("");
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showErrorMsg(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.bt_login, R.id.bt_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                String loginName = etName.getText().toString();
                String loginPassWord = etPassword.getText().toString();
                // 开始登录
                mPresenter.login(loginName, loginPassWord);
                break;
            case R.id.bt_clear:
                mPresenter.clear();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
