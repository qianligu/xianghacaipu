package com.jaxsen.xianghacaipu.ui.cook.presenter;

import com.jaxsen.xianghacaipu.ui.cook.bean.BannerList;
import com.jaxsen.xianghacaipu.ui.cook.contract.CookContract;

import rx.functions.Action1;

/**
 * Created by Administrator on 2017/4/10.
 */

public class BannerListPresenter extends CookContract.Presenter {
    @Override
    public void getBannerList() {
        mModel.getBannerList().subscribe(new Action1<BannerList>() {
            @Override
            public void call(BannerList bannerList) {
                mView.returnBannerList(bannerList);
            }
        });
    }
}
