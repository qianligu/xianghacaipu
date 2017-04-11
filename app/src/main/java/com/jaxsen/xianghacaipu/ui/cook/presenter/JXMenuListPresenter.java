package com.jaxsen.xianghacaipu.ui.cook.presenter;


import com.jaxsen.xianghacaipu.ui.cook.bean.JXMenuList;
import com.jaxsen.xianghacaipu.ui.cook.contract.JXMenuContract;

import rx.functions.Action1;


public  class JXMenuListPresenter extends JXMenuContract.Presenter {

    @Override
    public void getJXMenuList(String g1, String page) {
        mModel.getJXMenuList(g1,page).subscribe(new Action1<JXMenuList>() {
            @Override
            public void call(JXMenuList jxMenuList) {
                mView.getJXMenuList(jxMenuList);
            }
        });
    }
}
