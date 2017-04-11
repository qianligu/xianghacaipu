package com.jaxsen.xianghacaipu.ui.cook.contract;

import com.jaxsen.xianghacaipu.ui.cook.bean.SearchDetailList;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10.
 */

public interface SearchDetailContract {

    public abstract class Presenter extends BasePresenter<Model, View> {

        public abstract void getSearchDetailList(String keywords,String page);
    }

    public interface Model extends BaseModel {
        Observable<SearchDetailList> getSearchDetailList(String keywords, String page);
    }

    public interface View extends BaseView {
        void returnSearchDetailList(SearchDetailList searchDetailList);
    }
}
