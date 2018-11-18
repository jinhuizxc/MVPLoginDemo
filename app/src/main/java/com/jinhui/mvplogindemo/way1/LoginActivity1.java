package com.jinhui.mvplogindemo.way1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jinhui.mvplogindemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2018/11/18.
 * <p>
 * 方式一，并没有model层，mvc模式
 */
public class LoginActivity1 extends AppCompatActivity implements LoginView {

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
    @BindView(R.id.activity_user_login)
    LinearLayout activityUserLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void loginSuccess(String msg) {
        Toast.makeText(this,
                msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail(String msg) {
        Toast.makeText(this,
                msg, Toast.LENGTH_SHORT).show();
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
        pb.setVisibility(View.GONE);
    }

    @OnClick({R.id.bt_login, R.id.bt_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                loginPresenter.loginRequest(etName.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.bt_clear:
                loginPresenter.clear();
                break;
        }
    }
}
