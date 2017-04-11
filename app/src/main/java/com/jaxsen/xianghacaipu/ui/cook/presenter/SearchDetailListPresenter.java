package com.jaxsen.xianghacaipu.ui.cook.presenter;


import com.jaxsen.xianghacaipu.ui.cook.bean.SearchDetailList;
import com.jaxsen.xianghacaipu.ui.cook.contract.SearchDetailContract;

import rx.functions.Action1;


public class SearchDetailListPresenter extends SearchDetailContract.Presenter {

    @Override
    public void getSearchDetailList(String keywords, String page) {
        mModel.getSearchDetailList(keywords, page).subscribe(new Action1<SearchDetailList>() {
            @Override
            public void call(SearchDetailList searchDetailList) {
                mView.returnSearchDetailList(searchDetailList);
            }
        });
    }
}
