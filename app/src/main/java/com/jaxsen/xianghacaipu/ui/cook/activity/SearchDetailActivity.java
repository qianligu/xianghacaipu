package com.jaxsen.xianghacaipu.ui.cook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.cook.adapter.SearchDetailAdapter;
import com.jaxsen.xianghacaipu.ui.cook.bean.SearchDetailList;
import com.jaxsen.xianghacaipu.ui.cook.contract.SearchDetailContract;
import com.jaxsen.xianghacaipu.ui.cook.model.SearchDetailListModel;
import com.jaxsen.xianghacaipu.ui.cook.presenter.SearchDetailListPresenter;
import com.rock.mvplibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchDetailActivity extends BaseActivity<SearchDetailListPresenter, SearchDetailListModel> implements SearchDetailContract.View {
    @BindView(R2.id.recycler_search_detail)
    RecyclerView searchDetailRecycler;
    private SearchDetailAdapter searchDetailAdapter;
    @BindView(R2.id.layout_search_et)
    EditText editText;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search_detail;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
        mPresenter.getSearchDetailList(getSearchMsg(), "1");
    }

    @Override
    public void initView() {
        editText.setText(getSearchMsg());
        searchDetailAdapter = new SearchDetailAdapter(this, null);
        searchDetailRecycler.setAdapter(searchDetailAdapter);
        LinearLayoutManager detailManager = new LinearLayoutManager(this);
        detailManager.setOrientation(LinearLayoutManager.VERTICAL);
        searchDetailRecycler.setLayoutManager(detailManager);
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
    public void returnSearchDetailList(SearchDetailList searchDetailList) {
        searchDetailAdapter.updateSearchDetail(searchDetailList.getData().getDishs());
        searchDetailAdapter.notifyDataSetChanged();
    }

    @OnClick(R2.id.layout_search_goSearch)
    public void goSearch(View view) {
        String msg = editText.getText().toString();
        mPresenter.getSearchDetailList(msg, "1");
    }

    private String getSearchMsg() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String searchMsg = extras.getString("searchMsg");
        return searchMsg;
    }

}
