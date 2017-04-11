package com.jaxsen.xianghacaipu.ui.cook.presenter;

import com.jaxsen.xianghacaipu.ui.cook.bean.BannerList;
import com.jaxsen.xianghacaipu.ui.cook.contract.CookContract;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/4/10.
 */

public class BannerListPresenter extends CookContract.Presenter {
    @Override
    public void getBannerList() {
        mModel.getBannerList().subscribe(new Subscriber<BannerList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(BannerList bannerList) {
                mView.returnBannerList(bannerList);
            }
        });
    }
}
