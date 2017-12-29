package demo.example.com.pandalive.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.adapter.ViewAdapter;
import demo.example.com.pandalive.base.BaseFragment;
import demo.example.com.pandalive.bean.MyDuo;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;

/**
 * Created by 丁军明 on 2017/12/26.
 */

public class DuoFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private RecyclerView mRecy;
    private ViewAdapter mViewAdapter;

    @Override
    public void show(String ss, String type) {
        Gson gson = new Gson();
        MyDuo myDuo = gson.fromJson(ss, MyDuo.class);
        List<MyDuo.LiveBean> live = myDuo.getLive();
        mViewAdapter = new ViewAdapter(live, getActivity());
        mRecy.setAdapter(mViewAdapter);


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        mRecy = view.findViewById(R.id.Recy_duo);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecy.setLayoutManager(linearLayoutManager);
        String url1 = getArguments().getString("url");
//        Bundle arguments = getArguments();
//        String url = arguments.getString("url");
        presenter.getDataFromModel(url1,null);

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_duo;
    }

    public static DuoFragment newInstance(String s) {

        Bundle args = new Bundle();
        args.putString("url",s);
        DuoFragment fragment = new DuoFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
