package com.jaxsen.xianghacaipu.ui.cook.model;

import com.jaxsen.xianghacaipu.ui.cook.api.Api;
import com.jaxsen.xianghacaipu.ui.cook.bean.JXMenuList;
import com.jaxsen.xianghacaipu.ui.cook.contract.JXMenuContract;
import com.rock.mvplibrary.event.AndroidIOToMain;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10.
 */

public class JXMenuListModel implements JXMenuContract.Model {

    @Override
    public Observable<JXMenuList> getJXMenuList(String g1, String page) {
        return Api.getApiService().getJXMenuList(g1,page).compose(new AndroidIOToMain.IOToMainTransformer<JXMenuList>());
    }
}
