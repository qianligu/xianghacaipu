package com.jaxsen.xianghacaipu.ui.cook.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.cook.adapter.DinnerAdapter;
import com.jaxsen.xianghacaipu.ui.cook.bean.DinnerList;
import com.jaxsen.xianghacaipu.ui.cook.contract.DinnerContract;
import com.jaxsen.xianghacaipu.ui.cook.model.DinnerListModel;
import com.jaxsen.xianghacaipu.ui.cook.presenter.DinnerListPresenter;
import com.rock.mvplibrary.base.BaseFragment;

import butterknife.BindView;



/**
 * Created by Administrator on 2017/4/10.
 */

public class DinnerFragment extends BaseFragment<DinnerListPresenter,DinnerListModel> implements DinnerContract.View {
    @BindView(R2.id.recycler_dinner)
    RecyclerView dinner;
    private DinnerAdapter dinnerAdapter;

    public static final String TAG = DinnerFragment.class.getSimpleName();

    private String tag;
    private int  page  = 1;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dinner;
    }

    public DinnerFragment(String tag) {
        this.tag = tag;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
        mPresenter.getDinnerList(tag,page+"");
    }

    @Override
    public void initView() {
        dinnerAdapter = new DinnerAdapter(getActivity(),null);
        dinner.setAdapter(dinnerAdapter);
        LinearLayoutManager dinnerManager = new LinearLayoutManager(getActivity());
        dinnerManager.setOrientation(LinearLayoutManager.VERTICAL);
        dinner.setLayoutManager(dinnerManager);
    }

    @Override
    public void onStartLoad() {
        Log.e(TAG, "onStartLoad: " );
    }

    @Override
    public void onStopLoad() {
        Log.e(TAG, "onStopLoad: " );
    }

    @Override
    public void onError(String errorInfo) {
        Log.e(TAG, "onError: "+errorInfo );
    }

    @Override
    public void returnDinnerList(DinnerList dinnerList) {
        dinnerAdapter.updateDinner(dinnerList.getData());
    }
}
