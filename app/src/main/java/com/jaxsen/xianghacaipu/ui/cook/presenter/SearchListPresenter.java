package com.jaxsen.xianghacaipu.ui.cook.presenter;

import com.jaxsen.xianghacaipu.ui.cook.bean.SearchData;
import com.jaxsen.xianghacaipu.ui.cook.contract.SearchContract;
import rx.functions.Action1;

public class SearchListPresenter extends SearchContract.Presenter {

    @Override
    public void getSearchList() {
        mModel.getSearchList().subscribe(new Action1<SearchData>() {
            @Override
            public void call(SearchData searchList) {
                mView.returnSearchList(searchList);
            }
        });
    }
}
