package com.jaxsen.xianghacaipu.ui.cook.presenter;


import com.jaxsen.xianghacaipu.ui.cook.bean.DinnerList;
import com.jaxsen.xianghacaipu.ui.cook.contract.DinnerContract;

import rx.Subscriber;


public  class DinnerListPresenter extends DinnerContract.Presenter {

    @Override
    public void getDinnerList(String g1, String page) {
        mModel.getDinnerList(g1,page).subscribe(new Subscriber<DinnerList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(DinnerList dinnerList) {
                mView.returnDinnerList(dinnerList);
            }
        });
    }
}
