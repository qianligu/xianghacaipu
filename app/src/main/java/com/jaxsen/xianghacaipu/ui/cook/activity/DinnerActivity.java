package com.jaxsen.xianghacaipu.ui.cook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.cook.adapter.DinnerPagerAdapter;
import com.jaxsen.xianghacaipu.ui.cook.fragment.DinnerFragment;
import com.rock.mvplibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DinnerActivity extends BaseActivity {
    private static final String TAG = DinnerActivity.class.getSimpleName();
    @BindView(R2.id.activity_dinner_tab)
    TabLayout tabLayout;
    @BindView(R2.id.activity_dinner_vp)
    ViewPager vp;
    private List<String> titles;
    private List<Fragment> fragments;
    private DinnerPagerAdapter dinnerPagerAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_dinner;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        titles = new ArrayList<>();
        titles.add("早餐");
        titles.add("午餐");
        titles.add("晚餐");
        fragments = new ArrayList<>();
        fragments.add(new DinnerFragment("1"));
        fragments.add(new DinnerFragment("2"));
        fragments.add(new DinnerFragment("3"));
        dinnerPagerAdapter = new DinnerPagerAdapter(getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(dinnerPagerAdapter);
        tabLayout.setupWithViewPager(vp);

    }

    private String getPosition() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String position = bundle.getString("position");
        return position;
    }
}
