package com.jaxsen.xianghacaipu.ui.cook.api;

import com.jaxsen.xianghacaipu.ui.cook.bean.BannerList;

import retrofit2.http.GET;
import rx.Observable;


public interface ApiService {
    @GET("/main6/index/baseData?")
    Observable<BannerList> getBannnerList();
}
