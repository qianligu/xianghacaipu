package com.jaxsen.xianghacaipu.ui.cook.presenter;


import com.jaxsen.xianghacaipu.ui.cook.bean.EpicureList;
import com.jaxsen.xianghacaipu.ui.cook.contract.EpicureContract;

import rx.Subscriber;


public  class EpicureListPresenter extends EpicureContract.Presenter {

    @Override
    public void getEpicureList(String type, String page) {
        mModel.getEpicureList(type, page).subscribe(new Subscriber<EpicureList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(EpicureList epicureList) {
                mView.returnEpicureList(epicureList);
            }
        });
    }
}
