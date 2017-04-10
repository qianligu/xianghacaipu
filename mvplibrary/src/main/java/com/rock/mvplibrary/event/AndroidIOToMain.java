package com.rock.mvplibrary.event;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Rock on 2017/3/24.
 */

public class AndroidIOToMain {

    public static <T> Observable<T> ioToMain(Observable<T> observable){
        return observable.compose(new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        });
    }

    public static class IOToMainTransformer<T> implements Observable.Transformer<T,T>{

        @Override
        public Observable<T> call(Observable<T> observable) {
            return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    }

}
