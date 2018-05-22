package com.ylxt.gpmanagement.base.ui.fragment;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.presenter.view.BaseView;

/**
 * Created by 江婷婷 on 2018/5/14.
 */

public class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    public T mPresenter;

    @Override
    public void start() {

    }
}
