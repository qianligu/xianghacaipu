package com.jaxsen.xianghacaipu.ui.cook.presenter;


import com.jaxsen.xianghacaipu.ui.cook.bean.JXMenuList;
import com.jaxsen.xianghacaipu.ui.cook.contract.JXMenuContract;

import rx.Subscriber;


public  class JXMenuListPresenter extends JXMenuContract.Presenter {

    @Override
    public void getJXMenuList(String g1, String page) {
        mModel.getJXMenuList(g1,page).subscribe(new Subscriber<JXMenuList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(JXMenuList jxMenuList) {
                mView.getJXMenuList(jxMenuList);
            }
        });
    }
}
