package demo.example.com.pandalive.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;

import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.adapter.ZbAdapter;
import demo.example.com.pandalive.base.BaseFragment;
import demo.example.com.pandalive.bean.ZhiBo;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;

/**
 * Created by 丁军明 on 2017/12/22.
 */

public class CultureOne extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private PullToRefreshRecyclerView mRecy;
    private ZbAdapter zbAdapter;
    private static String ARG_PARAM1;
    private static String ARG_PARAM2;
    private boolean boo = false;

    @Override
    public void show(String ss, String type) {
        ZhiBo zhiBo = JSON.parseObject(ss, ZhiBo.class);
        List<ZhiBo.ListBean> list = zhiBo.getList();
        zbAdapter = new ZbAdapter(list, getActivity());
        mRecy.setAdapter(zbAdapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        getView(view);
    }

    private void getView(View view) {
        mRecy = view.findViewById(R.id.Cult_PullRecy);
        presenter.getDataFromModel(ARG_PARAM2, null);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        mRecy.setLayoutManager(gridLayoutManager);

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
                        zbAdapter.notifyDataSetChanged();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                mRecy.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRecy.setLoadMoreComplete();
                        Toast.makeText(getActivity(), "没有数据了", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.culture_first;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ARG_PARAM1 = getArguments().getString(ARG_PARAM1);
            ARG_PARAM2 = getArguments().getString(ARG_PARAM2);
        }

    }

    public static CultureOne newInstance(String param1, String param2) {
        CultureOne fragment = new CultureOne();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (boo) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.culture_first, null);
            getView(view);
            Log.e("onResume", ARG_PARAM2);
        }
        boo = true;

    }
}
