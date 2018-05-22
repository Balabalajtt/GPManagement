package com.ylxt.gpmanagement.work.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.ui.fragment.BaseMvpFragment;
import com.ylxt.gpmanagement.work.presenter.SubjectPresenter;
import com.ylxt.gpmanagement.work.presenter.view.SubjectView;
import com.ylxt.gpmanagement.work.ui.activity.KaiTiActivity;
import com.ylxt.gpmanagement.work.ui.activity.ShengbaoActivity;
import com.ylxt.gpmanagement.work.ui.activity.ShengbaoShowActivity;

/**
 * Created by 江婷婷 on 2018/5/10.
 */

public class SecondFragment extends BaseMvpFragment<SubjectPresenter> implements SubjectView, View.OnClickListener{

    private Button mBtShengbao;
    private Button mBtKaiti;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        mPresenter = new SubjectPresenter();
        mPresenter.mView = this;

        mBtShengbao = view.findViewById(R.id.bt_shengbao);
        mBtKaiti = view.findViewById(R.id.bt_kaiti);
        mBtShengbao.setOnClickListener(this);
        mBtKaiti.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_shengbao:
                mPresenter.checkShengbao();
                break;
            case R.id.bt_kaiti:
                startActivity(new Intent(getActivity(), KaiTiActivity.class));
                break;
        }
    }

    @Override
    public void onShengbao() {
        startActivity(new Intent(getActivity(), ShengbaoShowActivity.class));
    }

    @Override
    public void onUnShengbao() {
        startActivity(new Intent(getActivity(), ShengbaoActivity.class));
    }
}
