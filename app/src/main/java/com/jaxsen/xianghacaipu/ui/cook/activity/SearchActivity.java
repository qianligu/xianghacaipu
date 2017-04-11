package com.jaxsen.xianghacaipu.ui.cook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.cook.adapter.HotSearchAdapter;
import com.jaxsen.xianghacaipu.ui.cook.bean.SearchData;
import com.jaxsen.xianghacaipu.ui.cook.contract.SearchContract;
import com.jaxsen.xianghacaipu.ui.cook.model.SearchListModel;
import com.jaxsen.xianghacaipu.ui.cook.presenter.SearchListPresenter;
import com.rock.mvplibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity<SearchListPresenter,SearchListModel> implements SearchContract.View {
    @BindView(R2.id.recycler_hotSearch)
    RecyclerView hotRecycler;
    private HotSearchAdapter hotSearchAdapter;

    @BindView(R2.id.layout_search_et)
    EditText editText;
    @BindView(R2.id.layout_search_goSearch)
    TextView goSearch;
    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
        mPresenter.getSearchList();
    }

    @Override
    public void initView() {
        initHotSearch();
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
    public void returnSearchList(SearchData searchList) {
        hotSearchAdapter.updateUser(searchList.getData());
    }

    private void initHotSearch() {
        hotSearchAdapter = new HotSearchAdapter(this,null);
        hotRecycler.setAdapter(hotSearchAdapter);
        GridLayoutManager hotSearchManager = new GridLayoutManager(this,5);
        hotSearchManager.setOrientation(GridLayoutManager.VERTICAL);
        hotRecycler.setLayoutManager(hotSearchManager);
    }


    @OnClick(R2.id.layout_search_goSearch)
    public void goSearch(View view){
        String text = editText.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("searchMsg",text);
        Intent intent = new Intent(this, SearchDetailActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
