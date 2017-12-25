package demo.example.com.pandalive.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.adapter.SecondAdapter;
import demo.example.com.pandalive.base.BaseFragment;
import demo.example.com.pandalive.bean.MySecond;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;

/**
 * Created by 丁军明 on 2017/12/22.
 */

public class CultureTwo extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private RecyclerView mRecy;
    private EditText mEdit;
    private Button mFa;
    private SecondAdapter secondAdapter;

    @Override
    public void show(String ss, String type) {
        Gson gson = new Gson();
        MySecond mySecond = gson.fromJson(ss, MySecond.class);
        List<MySecond.DataBean.ContentBean> content = mySecond.getData().getContent();
        secondAdapter = new SecondAdapter(content, getActivity());
        mRecy.setAdapter(secondAdapter);
    }

    @Override
    protected void initData() {
        presenter.getDataFromModel("http://newcomment.cntv.cn/comment/list?prepage=20&app=ipandaApp&itemid=zhiboye_chat&nature=1&page=1", null);
    }

    @Override
    protected void initView(View view) {
        mEdit = view.findViewById(R.id.Edit_second);
        mFa = view.findViewById(R.id.FaSong);
        mRecy = view.findViewById(R.id.Recy_second);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecy.setLayoutManager(linearLayoutManager);
    }

    @Override
    public int getLayoutId() {
        return R.layout.culture_second;
    }
}
