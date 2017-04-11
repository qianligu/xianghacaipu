package com.jaxsen.xianghacaipu.ui.cook.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.cook.adapter.JXMenuAdapter;
import com.jaxsen.xianghacaipu.ui.cook.bean.JXMenuList;
import com.jaxsen.xianghacaipu.ui.cook.contract.JXMenuContract;
import com.jaxsen.xianghacaipu.ui.cook.model.JXMenuListModel;
import com.jaxsen.xianghacaipu.ui.cook.presenter.JXMenuListPresenter;
import com.rock.mvplibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class JXMenuActivity extends BaseActivity<JXMenuListPresenter, JXMenuListModel> implements JXMenuContract.View {

    @BindView(R2.id.recycler_jxmenu)
    RecyclerView jxMenu;

    @BindView(R2.id.activity_jxmenu_name)
    TextView name;

    private JXMenuAdapter jxMenuAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_jxmenu;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
        mPresenter.getJXMenuList("2405", "1");
    }

    @Override
    public void initView() {
        initJxMenu();
    }


    @Override
    public void onStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }

    @Override
    public void getJXMenuList(JXMenuList jxMenuList) {
        jxMenuAdapter.updateDinner(jxMenuList.getData().getDishs());
        name.setText(jxMenuList.getData().getName());
    }

    private void initJxMenu() {
        jxMenuAdapter = new JXMenuAdapter(this, null);
        jxMenu.setAdapter(jxMenuAdapter);
        LinearLayoutManager jxMenuManager = new LinearLayoutManager(this);
        jxMenuManager.setOrientation(LinearLayoutManager.VERTICAL);
        jxMenu.setLayoutManager(jxMenuManager);
    }

    @OnClick(R2.id.activity_jxmenu_back)
    public void backOnClick(View iew){
        finish();
    }

    @OnClick(R2.id.activity_jxmenu_share)
    public void shareOnClick(View iew){
        Toast.makeText(this, "点击了分享", Toast.LENGTH_SHORT).show();
    }


}
