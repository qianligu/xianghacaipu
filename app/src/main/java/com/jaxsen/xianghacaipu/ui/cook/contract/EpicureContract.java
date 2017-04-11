package com.jaxsen.xianghacaipu.ui.cook.contract;

import com.jaxsen.xianghacaipu.ui.cook.bean.EpicureList;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10.
 */

public interface EpicureContract {

    public abstract class Presenter extends BasePresenter<Model, View> {

        public abstract void getEpicureList(String type,String page);
    }

    public interface Model extends BaseModel {
        Observable<EpicureList> getEpicureList(String type, String page);
    }

    public interface View extends BaseView {
        void returnEpicureList(EpicureList epicureList);
    }
}
