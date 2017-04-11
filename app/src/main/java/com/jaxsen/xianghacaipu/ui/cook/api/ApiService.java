package com.jaxsen.xianghacaipu.ui.cook.api;

import com.jaxsen.xianghacaipu.ui.cook.bean.BannerList;
import com.jaxsen.xianghacaipu.ui.cook.bean.DinnerList;
import com.jaxsen.xianghacaipu.ui.cook.bean.SearchData;
import com.jaxsen.xianghacaipu.ui.cook.bean.SearchDetailList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface ApiService {

    @GET("/main6/index/baseData?")
    Observable<BannerList> getBannnerList();

    @GET("/main5/caipu/getDishList?type=typeRecommend")
    Observable<DinnerList> getDinnerList(@Query("g1")String g1,@Query("page")String page);

    @GET("/main6/search/getHotWords?")
    Observable<SearchData> getSearchList();

    @GET("/main6/search/byCaipu?type=caipu")
    Observable<SearchDetailList> getSearchDetailList(@Query("keywords")String keywords,@Query("page")String page);

}
