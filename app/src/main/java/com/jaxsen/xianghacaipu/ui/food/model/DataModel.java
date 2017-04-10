package com.jaxsen.xianghacaipu.ui.food.model;

import com.jaxsen.xianghacaipu.ui.food.api.Api;
import com.jaxsen.xianghacaipu.ui.food.bean.ParseNew;
import com.jaxsen.xianghacaipu.ui.food.contract.FoodGetData;
import com.rock.mvplibrary.event.AndroidIOToMain;

import rx.Observable;

/**
 * Created by ALong on 2017/4/10.
 */

public class DataModel implements FoodGetData.Model {

    @Override
    public Observable<ParseNew> getList() {

        return Api.getApiService().getList().compose(new AndroidIOToMain.IOToMainTransformer<ParseNew>());
    }
}
