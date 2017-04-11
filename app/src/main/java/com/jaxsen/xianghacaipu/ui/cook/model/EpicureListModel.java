package com.jaxsen.xianghacaipu.ui.cook.model;

import com.jaxsen.xianghacaipu.ui.cook.api.Api;
import com.jaxsen.xianghacaipu.ui.cook.bean.EpicureList;
import com.jaxsen.xianghacaipu.ui.cook.contract.EpicureContract;
import com.rock.mvplibrary.event.AndroidIOToMain;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10.
 */

public class EpicureListModel implements EpicureContract.Model {

    @Override
    public Observable<EpicureList> getEpicureList(String type, String page) {
        return Api.getApiService().getEpicureList(type,page).compose(new AndroidIOToMain.IOToMainTransformer<EpicureList>());

    }
}
