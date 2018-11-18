package com.jinhui.mvplogindemo.way2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jinhui.mvplogindemo.R;
import com.jinhui.mvplogindemo.way2.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jh on 2018/9/25.
 * Email: 1004260403@qq.com
 *
 * 方式二
 */
public class LoginActivity2 extends AppCompatActivity implements LoginView {

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

    LoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_login, R.id.bt_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                loginPresenter.login();
                break;
            case R.id.bt_clear:
                loginPresenter.clear();
                break;
        }
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
    public String getName() {
        return etName.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void showSuccessMsg(User user) {
        Toast.makeText(this, user.getName() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMsg(String msg) {
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
}
