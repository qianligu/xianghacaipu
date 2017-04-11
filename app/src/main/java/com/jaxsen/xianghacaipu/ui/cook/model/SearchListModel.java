package com.jaxsen.xianghacaipu.ui.cook.model;

import com.jaxsen.xianghacaipu.ui.cook.api.Api;
import com.jaxsen.xianghacaipu.ui.cook.bean.SearchData;
import com.jaxsen.xianghacaipu.ui.cook.contract.SearchContract;
import com.rock.mvplibrary.event.AndroidIOToMain;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10.
 */

public class SearchListModel implements SearchContract.Model {

    @Override
    public Observable<SearchData> getSearchList() {
        return Api.getApiService().getSearchList().compose(new AndroidIOToMain.IOToMainTransformer<SearchData>());

    }
}
