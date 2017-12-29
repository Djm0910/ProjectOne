package demo.example.com.pandalive.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.adapter.MyTabAdapter;
import demo.example.com.pandalive.app.App;
import demo.example.com.pandalive.base.BaseFragment;
import demo.example.com.pandalive.bean.MyTab;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;
import demo.example.com.pandalive.ui.acctivity.MainActivity;
import demo.example.com.pandalive.utils.NoScrollViewPager;

/**
 * Created by 丁军明 on 2017/12/19.
 */

public class CultureFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {

    private List<MyTab.TablistBean> mTab = new ArrayList<>();
    private ArrayList<Fragment> mList = new ArrayList<>();
    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;
    private MyTabAdapter myTabAdapter;

    @Override
    public void show(String ss, String type) {
        if (ss != null) {
            Gson gson = new Gson();
            MyTab myTab = gson.fromJson(ss, MyTab.class);
            if (mTab.isEmpty()) {
                mTab = myTab.getTablist();
            }
            getFragment();
            myTabAdapter = new MyTabAdapter(getFragmentManager(), mTab, mList);
            mViewPager.setAdapter(myTabAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            myTabAdapter.notifyDataSetChanged();
            mViewPager.setOffscreenPageLimit(8);
        }

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        mList.clear();
        App.mLastFragment = this;
        new MainActivity().getInter(new MainActivity.FaSong() {
            @Override
            public void setData(String url) {
                presenter.getDataFromModel(url, null);
            }
        });
        App.mActivity.mHuDong.setVisibility(View.GONE);
        App.mActivity.mPanda.setVisibility(View.GONE);
        App.mActivity.title.setVisibility(View.VISIBLE);
        mTabLayout = view.findViewById(R.id.TabLayout);
        mViewPager = view.findViewById(R.id.ViewPager);


    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_culture;
    }

    public void getFragment() {
        CultureliveFragment cultureliveFragment = CultureliveFragment.newInstance("", mTab.get(0).getUrl());
        mList.add(cultureliveFragment);
        for (int i = 1; i < mTab.size(); i++) {
            FuYongFragment fuYongFragment = FuYongFragment.newInstance("", mTab.get(i).getId());
            mList.add(fuYongFragment);
        }
    }

}
