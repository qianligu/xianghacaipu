package com.jaxsen.xianghacaipu.ui.food.contract;

import com.jaxsen.xianghacaipu.ui.food.bean.ParseNew;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import rx.Observable;


/**
 * Created by ALong on 2017/4/10.
 */

public interface FoodGetData {


    abstract class Presenter extends BasePresenter<Model,View>{

        public abstract void getList();
    }

    interface Model extends BaseModel{
        Observable<ParseNew> getList();
    }

    interface View extends BaseView{
        void returnList(ParseNew parseNew);
    }
}
