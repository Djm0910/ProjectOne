package demo.example.com.pandalive.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.google.gson.Gson;

import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.adapter.FuAdapter;
import demo.example.com.pandalive.base.BaseFragment;
import demo.example.com.pandalive.bean.FuYong;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;

/**
 * Created by 丁军明 on 2017/12/21.
 */

public class FuYongFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private static String ARG_PARAM1;
    private static String ARG_PARAM2;
    private PullToRefreshRecyclerView mRecy;
    private FuAdapter fuAdapter;
    private final static String HAHA = "HAHA";

    @Override
    public void show(String ss, String type) {
        switch (type) {
            case HAHA:
                if (ss != null) {
                    Gson gson = new Gson();
                    FuYong fuYong = gson.fromJson(ss, FuYong.class);
                    List<FuYong.VideoBean> video = fuYong.getVideo();
                    fuAdapter = new FuAdapter(video, getActivity());
                    mRecy.setAdapter(fuAdapter);
                }
                break;
        }


    }

    @Override
    protected void initData() {
        String url = "http://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1";
        presenter.getDataFromModel(url, HAHA);
    }

    @Override
    protected void initView(View view) {
        mRecy = view.findViewById(R.id.Recy_Fu);
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
                        fuAdapter.notifyDataSetChanged();
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ARG_PARAM1 = getArguments().getString(ARG_PARAM1);
            ARG_PARAM2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public static FuYongFragment newInstance(String param1, String param2) {
        FuYongFragment fragment = new FuYongFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fuyong_recy;
    }
}
