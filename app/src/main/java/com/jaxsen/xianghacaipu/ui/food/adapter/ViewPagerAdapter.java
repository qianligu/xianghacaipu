package com.jaxsen.xianghacaipu.ui.food.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALong on 2017/4/10.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> data;

    public ViewPagerAdapter(FragmentManager fm,List<Fragment> data) {
        super(fm);
        if (fm == null) {
            this.data=new ArrayList<>();
        }else {
            this.data=data;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }
}
