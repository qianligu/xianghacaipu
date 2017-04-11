package com.jaxsen.xianghacaipu.ui.cook.presenter;


import com.jaxsen.xianghacaipu.ui.cook.bean.SearchDetailList;
import com.jaxsen.xianghacaipu.ui.cook.contract.SearchDetailContract;

import rx.Subscriber;


public class SearchDetailListPresenter extends SearchDetailContract.Presenter {

    @Override
    public void getSearchDetailList(String keywords, String page) {
        mModel.getSearchDetailList(keywords, page).subscribe(new Subscriber<SearchDetailList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(SearchDetailList searchDetailList) {
                mView.returnSearchDetailList(searchDetailList);
            }
        });
    }
}
