package com.ylxt.gpmanagement.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.presenter.view.BaseView;


/**
 * Created by 江婷婷 on 2018/5/14.
 */

public class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void start() {

    }
}
