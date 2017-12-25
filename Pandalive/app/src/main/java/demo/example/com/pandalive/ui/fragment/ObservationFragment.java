package demo.example.com.pandalive.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.google.gson.Gson;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.adapter.ThreeAdapter;
import demo.example.com.pandalive.app.App;
import demo.example.com.pandalive.base.BaseFragment;
import demo.example.com.pandalive.bean.MyThree;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;
import demo.example.com.pandalive.ui.acctivity.MainActivity;
import demo.example.com.pandalive.ui.acctivity.WebActivity;

/**
 * Created by 丁军明 on 2017/12/19.
 */

public class ObservationFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private PullToRefreshRecyclerView mRecy;
    private MyThree myThree;
    private ThreeAdapter mThreeAdapter;

    @Override
    public void show(String ss, String type) {
        if (ss != null) {
            Gson gson = new Gson();
            myThree = gson.fromJson(ss, MyThree.class);
            mThreeAdapter = new ThreeAdapter(myThree, getActivity());
            mRecy.setAdapter(mThreeAdapter);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        App.mLastFragment = this;
        App.mActivity.mHuDong.setVisibility(View.GONE);
        App.mActivity.mPanda.setVisibility(View.GONE);
        App.mActivity.title.setVisibility(View.VISIBLE);
        new MainActivity().getInter(new MainActivity.FaSong() {
            @Override
            public void setData(String url) {
                presenter.getDataFromModel(url, null);
            }
        });
        mRecy = view.findViewById(R.id.Pull_Recy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecy.setLayoutManager(linearLayoutManager);


        mRecy.setPullRefreshEnabled(true);
        mRecy.setLoadingMoreEnabled(false);
        mRecy.displayLastRefreshTime(true);
        mRecy.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                mRecy.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //模拟没有数据的情况
                        mRecy.setRefreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_observation;
    }
}
