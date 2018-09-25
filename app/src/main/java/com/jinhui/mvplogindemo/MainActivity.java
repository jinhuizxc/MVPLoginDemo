package com.jinhui.mvplogindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jinhui.mvplogindemo.mvp1.LoginActivity;
import com.jinhui.mvplogindemo.mvp2.login.LoginActivity1;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 两种方式进行mvp的登录测试
 */
public class MainActivity extends AppCompatActivity {


    @BindView(R.id.bt_login1)
    Button btLogin1;
    @BindView(R.id.bt_login2)
    Button btLogin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_login1, R.id.bt_login2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login1:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.bt_login2:
                startActivity(new Intent(this, LoginActivity1.class));
                break;
        }
    }
}
