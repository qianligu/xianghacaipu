package com.jaxsen.xianghacaipu.ui.food.fragment;

import android.util.Log;
import android.widget.GridView;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.ui.food.adapter.GrideAdapter;
import com.jaxsen.xianghacaipu.ui.food.bean.ParseNew;
import com.jaxsen.xianghacaipu.ui.food.contract.FoodGetData;
import com.jaxsen.xianghacaipu.ui.food.model.DataModel;
import com.jaxsen.xianghacaipu.ui.food.presenter.DataPresenter;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class FoodTwoPage extends BaseFragment<DataPresenter,DataModel> implements FoodGetData.View {


    private static final String TAG = FoodTwoPage.class.getSimpleName();
    @BindView(R.id.food2_grid)
    GridView mGridView;


    private GrideAdapter GridAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_two_page;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
        mPresenter.getList();
    }

    @Override
    public void initView() {

        GridAdapter = new GrideAdapter(getActivity(),null);
        mGridView.setAdapter(GridAdapter);
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
    public void returnList(ParseNew parseNew) {

        Log.e(TAG, "returnList: " +parseNew.getRes());

        GridAdapter.addRes(parseNew.getData().getData().get(0).getList());
    }
}
