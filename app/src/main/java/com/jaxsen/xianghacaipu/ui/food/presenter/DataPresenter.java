package com.jaxsen.xianghacaipu.ui.food.presenter;

import android.util.Log;

import com.jaxsen.xianghacaipu.ui.food.bean.ParseNew;
import com.jaxsen.xianghacaipu.ui.food.contract.FoodGetData;

import rx.Subscriber;

/**
 * Created by ALong on 2017/4/10.
 */

public class DataPresenter extends FoodGetData.Presenter {


    private static final String TAG = DataPresenter.class.getSimpleName();

    @Override
    public void getList() {
        mModel.getList().subscribe(new Subscriber<ParseNew>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: " );
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " );
            }

            @Override
            public void onNext(ParseNew parseNew) {
                Log.e(TAG, "onNext: " );
                mView.returnList(parseNew);
            }
        });
    }
}
