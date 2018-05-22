package com.ylxt.gpmanagement.work.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.ui.fragment.BaseFragment;

/**
 * Created by 江婷婷 on 2018/5/10.
 */

public class ThirdFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        return view;
    }
}
