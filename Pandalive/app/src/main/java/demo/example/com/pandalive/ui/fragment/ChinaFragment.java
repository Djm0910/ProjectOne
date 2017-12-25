package demo.example.com.pandalive.ui.fragment;

import android.view.View;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.app.App;
import demo.example.com.pandalive.base.BaseFragment;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;
import demo.example.com.pandalive.ui.acctivity.MainActivity;

/**
 * Created by 丁军明 on 2017/12/19.
 */

public class ChinaFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    @Override
    public void show(String ss,String type) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
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
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_china;
    }
}
