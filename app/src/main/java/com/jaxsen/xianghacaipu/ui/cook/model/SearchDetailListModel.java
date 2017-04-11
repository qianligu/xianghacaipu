package com.jaxsen.xianghacaipu.ui.cook.model;

import com.jaxsen.xianghacaipu.ui.cook.api.Api;
import com.jaxsen.xianghacaipu.ui.cook.bean.SearchDetailList;
import com.jaxsen.xianghacaipu.ui.cook.contract.SearchDetailContract;
import com.rock.mvplibrary.event.AndroidIOToMain;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10.
 */

public class SearchDetailListModel implements SearchDetailContract.Model {

    @Override
    public Observable<SearchDetailList> getSearchDetailList(String keywords, String page) {
        return Api.getApiService().getSearchDetailList(keywords,page).compose(new AndroidIOToMain.IOToMainTransformer<SearchDetailList>());

    }
}
