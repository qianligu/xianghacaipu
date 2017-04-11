package com.jaxsen.xianghacaipu.ui.cook.contract;

import com.jaxsen.xianghacaipu.ui.cook.bean.DinnerList;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10.
 */

public interface DinnerContract {

    public abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getDinnerList(String g1,String page);
    }

    public interface Model extends BaseModel {
        Observable<DinnerList> getDinnerList(String g1,String page);
    }

    public interface View extends BaseView {
        void returnDinnerList(DinnerList dinnerList);
    }

}
