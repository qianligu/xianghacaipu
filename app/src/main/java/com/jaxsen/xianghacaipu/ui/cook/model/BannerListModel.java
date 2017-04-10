package com.jaxsen.xianghacaipu.ui.cook.model;

import com.jaxsen.xianghacaipu.ui.cook.api.Api;
import com.jaxsen.xianghacaipu.ui.cook.bean.BannerList;
import com.jaxsen.xianghacaipu.ui.cook.contract.CookContract;
import com.rock.mvplibrary.event.AndroidIOToMain;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10.
 */

public class BannerListModel implements CookContract.Model {

    @Override
    public Observable<BannerList> getBannerList() {
        return Api.getApiService().getBannnerList().compose(new AndroidIOToMain.IOToMainTransformer<BannerList>());
    }
}
