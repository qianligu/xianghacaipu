package com.jaxsen.xianghacaipu.ui.food.api;


import com.jaxsen.xianghacaipu.ui.food.bean.ParseNew;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ALong on 2017/3/28.
 */

public interface Apiservice {

    @GET("/main6/tie/getList?cid=10&mid=25&page=1&pageTime=")
    Observable<ParseNew> getList();
}
