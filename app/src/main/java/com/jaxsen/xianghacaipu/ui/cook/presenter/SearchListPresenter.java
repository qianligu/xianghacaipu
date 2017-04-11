package com.jaxsen.xianghacaipu.ui.cook.presenter;

import com.jaxsen.xianghacaipu.ui.cook.bean.SearchData;
import com.jaxsen.xianghacaipu.ui.cook.contract.SearchContract;

import rx.Subscriber;

public class SearchListPresenter extends SearchContract.Presenter {

    @Override
    public void getSearchList() {
        mModel.getSearchList().subscribe(new Subscriber<SearchData>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(SearchData searchData) {
                mView.returnSearchList(searchData);
            }
        });
    }
}
