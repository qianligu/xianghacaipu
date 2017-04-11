package com.jaxsen.xianghacaipu.ui.cook.presenter;


import com.jaxsen.xianghacaipu.ui.cook.bean.DinnerList;
import com.jaxsen.xianghacaipu.ui.cook.contract.DinnerContract;

import rx.functions.Action1;


public  class DinnerListPresenter extends DinnerContract.Presenter {

    @Override
    public void getDinnerList(String g1, String page) {
        mModel.getDinnerList(g1,page).subscribe(new Action1<DinnerList>() {
            @Override
            public void call(DinnerList dinnerList) {
                mView.returnDinnerList(dinnerList);
            }
        });
    }
}
