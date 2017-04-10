package com.jaxsen.xianghacaipu.ui.cook.model;

import com.jaxsen.xianghacaipu.ui.cook.api.Api;
import com.jaxsen.xianghacaipu.ui.cook.bean.DinnerList;
import com.jaxsen.xianghacaipu.ui.cook.contract.DinnerContract;
import com.rock.mvplibrary.event.AndroidIOToMain;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10.
 */

public class DinnerListModel implements DinnerContract.Model {

    @Override
    public Observable<DinnerList> getDinnerList(String g1, String page) {
        return Api.getApiService().getDinnerList(g1,page).compose(new AndroidIOToMain.IOToMainTransformer<DinnerList>());
    }
}
