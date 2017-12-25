package demo.example.com.pandalive.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.alibaba.fastjson.JSON;
import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.adapter.HomeAdapter;
import demo.example.com.pandalive.app.App;
import demo.example.com.pandalive.base.BaseFragment;
import demo.example.com.pandalive.bean.MyHome;
import demo.example.com.pandalive.bean.MyJc;
import demo.example.com.pandalive.bean.MyShi;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;
import demo.example.com.pandalive.ui.acctivity.MainActivity;
import demo.example.com.pandalive.ui.acctivity.VideoActivity;
import demo.example.com.pandalive.ui.acctivity.WebActivity;
import demo.example.com.pandalive.utils.FragmentBuilder;

/**
 * Created by 丁军明 on 2017/12/19.
 */

public class HomeFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private PullToRefreshRecyclerView mRecy;
    private final static String HOME = "HOME";
    private final static String JING = "JING";
    private final static String GUN = "GUN";
    private MyHome.DataBean data;
    private HomeAdapter homeAdapter;
    private List<MyShi.ListBean> list;
    private List<MyJc.ListBean> list1;
    private MyHome myHome;
    private FrameLayout mFra;


    @Override
    public void show(String ss, String type) {
        switch (type) {
            case HOME:
                if (ss != null) {

                    Gson gson = new Gson();
                    myHome = gson.fromJson(ss, MyHome.class);
                    data = myHome.getData();
                    String listurl = data.getCctv().getListurl();
                    presenter.getDataFromModel(listurl, JING);

                }
                break;
            case JING:
                if (ss != null) {
                    MyJc myJc = JSON.parseObject(ss, MyJc.class);
                    list1 = myJc.getList();
                    String listUrls = data.getList().get(0).getListUrl();
                    presenter.getDataFromModel(listUrls, GUN);
                }
                break;
            case GUN:
                if (ss != null) {
                    MyShi myShi = JSON.parseObject(ss, MyShi.class);
                    list = myShi.getList();
                    homeAdapter = new HomeAdapter(getActivity(), list1, list, data);
                    mRecy.setAdapter(homeAdapter);
                    homeAdapter.OnItemClick(new HomeAdapter.OnItem() {
                        @Override
                        public void setData(View view, int position) {
                            Intent intent = new Intent(getActivity(), VideoActivity.class);
                            startActivity(intent);
                        }
                    });
                }
                break;
        }

    }


    @Override
    protected void initData() {
    }

    @Override
    protected void initView(final View view) {
        App.mLastFragment = this;
        new MainActivity().getInter(new MainActivity.FaSong() {
            @Override
            public void setData(String url) {
                presenter.getDataFromModel(url, HOME);
            }
        });
        App.mActivity.mPanda.setVisibility(View.VISIBLE);
        App.mActivity.mHuDong.setVisibility(View.VISIBLE);
        App.mActivity.title.setVisibility(View.GONE);
      //  mFra = view.findViewById(R.id.Fragment_child);
        mRecy = view.findViewById(R.id.Recy);
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
                        homeAdapter.notifyDataSetChanged();
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
        return R.layout.fragment_home;
    }
}
