package com.ylxt.gpmanagement.work.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.BottomNavigationViewHelper;
import com.ylxt.gpmanagement.base.ui.activity.BaseActivity;
import com.ylxt.gpmanagement.work.ui.adapter.MainPagerAdapter;
import com.ylxt.gpmanagement.work.ui.fragment.FirstFragment;
import com.ylxt.gpmanagement.work.ui.fragment.ForthFragment;
import com.ylxt.gpmanagement.work.ui.fragment.SecondFragment;
import com.ylxt.gpmanagement.work.ui.fragment.ThirdFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private MainPagerAdapter mPagerAdapter;
    private ArrayList<Fragment> mFragments;
    private BottomNavigationView mNavigationView;
    private MenuItem menuItem;

    private String[] mTitles = {"首页", "毕设", "消息", "我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        mFragments = new ArrayList<>();
        mFragments.add(new FirstFragment());
        mFragments.add(new SecondFragment());
        mFragments.add(new ThirdFragment());
        mFragments.add(new ForthFragment());

        mViewPager = findViewById(R.id.view_pager);
        mNavigationView = findViewById(R.id.nv_main);
        BottomNavigationViewHelper.removeShifMode(mNavigationView);
        mPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                menuItem = item;
                switch (item.getItemId()) {
                    case R.id.nv_one:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.nv_two:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.nv_three:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.nv_four:
                        mViewPager.setCurrentItem(3);
                }
                return false;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    mNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = mNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }

}
