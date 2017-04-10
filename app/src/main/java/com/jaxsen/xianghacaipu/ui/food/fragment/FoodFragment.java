package com.jaxsen.xianghacaipu.ui.food.fragment;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.food.adapter.ViewPagerAdapter;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/4/9.
 */

public class FoodFragment extends BaseFragment implements ViewPager.OnPageChangeListener, View.OnClickListener {
    public static final String TAG = FoodFragment.class.getName();

    @BindView(R2.id.food_viewPager)
    ViewPager mViewPager;

    @BindView(R2.id.food_page_title)
    View mPagerTitle;
    @BindView(R2.id.food_page_find)
    TextView mFind;
    @BindView(R2.id.food_page_new)
    TextView mNew;
    @BindView(R2.id.food_page_indicator)
    View mIndicator;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_food;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void initView() {
        mViewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(),getFragment()));
        mViewPager.addOnPageChangeListener(this);
        mFind.setOnClickListener(this);
        mNew.setOnClickListener(this);
    }

    private List<Fragment> getFragment() {
        List<Fragment> data=new ArrayList<>();
        data.add(new FoodOnePage());
        data.add(new FoodTwoPage());
        return data;
    }
    public void moveTitleIndicator(float offset){
        int width = mPagerTitle.getWidth();
        mIndicator.setTranslationX(offset * width / 2);
        switch ((int) offset) {
            case 0:
                mNew.setTextColor(Color.GRAY);
                mFind.setTextColor(Color.WHITE);

                break;
            case 1:
                mNew.setTextColor(Color.WHITE);
                mFind.setTextColor(Color.GRAY);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        moveTitleIndicator(position+positionOffset);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.food_page_find:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.food_page_new:
                mViewPager.setCurrentItem(1);
                break;
        }
    }
}
