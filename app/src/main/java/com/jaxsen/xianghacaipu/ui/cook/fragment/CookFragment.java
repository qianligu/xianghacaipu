package com.jaxsen.xianghacaipu.ui.cook.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.cook.activity.DinnerActivity;
import com.jaxsen.xianghacaipu.ui.cook.activity.SearchActivity;
import com.jaxsen.xianghacaipu.ui.cook.adapter.NousAdapter;
import com.jaxsen.xianghacaipu.ui.cook.adapter.UserAdapter;
import com.jaxsen.xianghacaipu.ui.cook.bean.BannerList;
import com.jaxsen.xianghacaipu.ui.cook.contract.CookContract;
import com.jaxsen.xianghacaipu.ui.cook.model.BannerListModel;
import com.jaxsen.xianghacaipu.ui.cook.presenter.BannerListPresenter;
import com.jaxsen.xianghacaipu.utils.BannerLoader;
import com.rock.mvplibrary.base.BaseFragment;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class CookFragment extends BaseFragment<BannerListPresenter,BannerListModel> implements CookContract.View, ViewPager.OnPageChangeListener, OnBannerListener, View.OnClickListener {
   @BindView(R2.id.banner)
    Banner mBanner;
    private List<String> images;

    @BindView(R2.id.recycler_nous)
    RecyclerView nous;
    @BindView(R2.id.fragment_cook_topic_image)
    ImageView topic_image;
    @BindView(R2.id.fragment_cook_topic_title)
    TextView topic_title;
    @BindView(R2.id.fragment_cook_topic_subTitle)
    TextView topic_subTitle;

    @BindView(R2.id.recycler_user)
    RecyclerView user;

    @BindView(R2.id.fragment_cook_iv)
    ImageView iv;

    @BindView(R2.id.layout_search)
    LinearLayout search;


    public static final String TAG = CookFragment.class.getName();
    private NousAdapter nousAdapter;
    private UserAdapter userAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cook;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
        mPresenter.getBannerList();
    }

    @Override
    public void initView() {
        initNous();
        initUser();
        search.setOnClickListener(this);
    }



    @Override
    public void onStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }

    @Override
    public void returnBannerList(BannerList bannerList) {
        setBanner(bannerList.getData().getBannerData());
        nousAdapter.updateNous(bannerList.getData().getNousData());
        userAdapter.updateUser(bannerList.getData().getUserData());
        setTopic(bannerList.getData().getTopicData().get(0));

    }

    private void setBanner(List<BannerList.DataBean.BannerData> bannerData){
        images = new ArrayList<>();
        for (int i = 0; i < bannerData.size(); i++) {
            images.add(bannerData.get(i).getImg());
        }
        mBanner.setImages(images).setImageLoader(new BannerLoader()).start();
        mBanner.setOnPageChangeListener(this);
        mBanner.setBannerAnimation(new Transformer().FlipHorizontal);
        mBanner.setOnBannerListener(this);
    }


    private void initNous() {
        nousAdapter = new NousAdapter(getActivity(),null);
        nous.setAdapter(nousAdapter);
        LinearLayoutManager nousManager = new LinearLayoutManager(getActivity());
        nousManager.setOrientation(LinearLayoutManager.VERTICAL);
        nous.setLayoutManager(nousManager);
    }

    private void initUser() {
        userAdapter = new UserAdapter(getActivity(),null);
        user.setAdapter(userAdapter);
        LinearLayoutManager userManager = new LinearLayoutManager(getActivity());
        userManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        user.setLayoutManager(userManager);
    }


    private void setTopic(BannerList.DataBean.TopicData topicData){
        Glide.with(getActivity()).load(topicData.getImgs()).into(topic_image);
        topic_subTitle.setText(topicData.getSubtitle());
        topic_title.setText(topicData.getTitle());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position==1||position==4) {
            iv.setImageResource(R.mipmap.i_ico_homepage_sancan_zao);
        }else if (position==2){
            iv.setImageResource(R.mipmap.i_ico_homepage_sancan_zhong);
        }else if(position==3){
            iv.setImageResource(R.mipmap.i_ico_homepage_sancan_wan);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void OnBannerClick(int i) {
        Log.e(TAG, "OnBannerClick:当前点击项为 "+i );
        Bundle bundle = new Bundle();
        bundle.putString("position",i+"");
        Intent intent = new Intent(getActivity(), DinnerActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(), SearchActivity.class));
    }
}
