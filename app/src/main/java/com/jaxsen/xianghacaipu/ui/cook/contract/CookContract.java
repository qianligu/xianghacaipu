package com.jaxsen.xianghacaipu.ui.cook.contract;

import com.jaxsen.xianghacaipu.ui.cook.bean.BannerList;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10.
 */

public interface CookContract {

    public abstract class Presenter extends BasePresenter<Model, View> {
        //轮播+人气推荐+头条
        public abstract void getBannerList();
    }

    public interface Model extends BaseModel {
        Observable<BannerList> getBannerList();
    }

    public interface View extends BaseView {
        void returnBannerList(BannerList bannerList);
    }
}
