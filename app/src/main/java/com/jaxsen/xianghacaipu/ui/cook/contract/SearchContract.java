package com.jaxsen.xianghacaipu.ui.cook.contract;

import com.jaxsen.xianghacaipu.ui.cook.bean.SearchData;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10.
 */

public interface SearchContract {

    public abstract class Presenter extends BasePresenter<Model, View> {
        //轮播+人气推荐+头条
        public abstract void getSearchList();
    }

    public interface Model extends BaseModel {
        Observable<SearchData> getSearchList();
    }

    public interface View extends BaseView {
        void returnSearchList(SearchData searchList);
    }
}
