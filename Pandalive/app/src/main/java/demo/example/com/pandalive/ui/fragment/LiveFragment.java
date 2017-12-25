package demo.example.com.pandalive.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.google.gson.Gson;

import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.adapter.MyFour;
import demo.example.com.pandalive.adapter.ThreeAdapter;
import demo.example.com.pandalive.app.App;
import demo.example.com.pandalive.base.BaseFragment;
import demo.example.com.pandalive.bean.Gun;
import demo.example.com.pandalive.bean.GunGun;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;
import demo.example.com.pandalive.ui.acctivity.MainActivity;

/**
 * Created by 丁军明 on 2017/12/19.
 */

public class LiveFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private PullToRefreshRecyclerView mRecy;
    private Gun gun;
    private final static String TUPIAN = "TUPIAN";
    private final static String SHUJU = "SHUJU";
    private MyFour myFour;

    @Override
    public void show(String ss, String type) {
        switch (type) {
            case TUPIAN:
                if (ss != null) {
                    Gson gson = new Gson();
                    gun = gson.fromJson(ss, Gun.class);
                    presenter.getDataFromModel(gun.getData().getListurl(), SHUJU);
                }
                break;
            case SHUJU:
                if (ss != null) {
                    Gson gson = new Gson();
                    GunGun gunGun = gson.fromJson(ss, GunGun.class);
                    List<GunGun.ListBean> list = gunGun.getList();
                    myFour = new MyFour(gun, list, getActivity());
                    mRecy.setAdapter(myFour);

                }
                break;
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
        App.mLastFragment = this;
        new MainActivity().getInter(new MainActivity.FaSong() {
            @Override
            public void setData(String url) {
                presenter.getDataFromModel(url, TUPIAN);
            }
        });
        mRecy = view.findViewById(R.id.Live_recy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecy.setLayoutManager(linearLayoutManager);


        mRecy.setPullRefreshEnabled(true);
        mRecy.setLoadingMoreEnabled(true);
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
                mRecy.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRecy.setLoadMoreComplete();


                    }
                }, 2000);

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_live;
    }
}
