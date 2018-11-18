package com.jinhui.mvplogindemo.way3.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jinhui.mvplogindemo.way3.utils.TUtil;


/**
 * Created by jh on 2018/9/20.
 * Email: 1004260403@qq.com
 */
public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {

    protected P mPresenter;
    protected M mModel;
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        mPresenter = TUtil.getT(this, 0);
        mModel= TUtil.getT(this,1);
        mContext = this;
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }

        this.initPresenter();
        this.initView();
    }

    protected abstract int getLayoutId();

    public abstract void initView();

    public abstract void initPresenter();

}
