package demo.example.com.pandalive.ui.acctivity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.google.gson.Gson;

import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.app.App;
import demo.example.com.pandalive.base.BaseActivity;
import demo.example.com.pandalive.bean.MyTitle;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;
import demo.example.com.pandalive.ui.fragment.ChinaFragment;
import demo.example.com.pandalive.ui.fragment.CultureFragment;
import demo.example.com.pandalive.ui.fragment.HomeFragment;
import demo.example.com.pandalive.ui.fragment.LiveFragment;
import demo.example.com.pandalive.ui.fragment.ObservationFragment;
import demo.example.com.pandalive.utils.FragmentBuilder;

import static demo.example.com.pandalive.R.id.view;

public class MainActivity extends BaseActivity<NetPresenter, NetModel> implements NetContract.View {
    private RadioGroup mRg;
    private RadioButton mOne, mTwo, mThree, mFour, mFive;
    private MyTitle myTitle;
    private boolean isQuit = false;
    private static String url;



    @Override
    protected void initData() {
        mPresenter.getDataFromModel("http://www.ipanda.com/kehuduan/dibubiaoqian/index.json", null);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        mOne = (RadioButton) findViewById(R.id.One);
        mTwo = (RadioButton) findViewById(R.id.Two);
        mThree = (RadioButton) findViewById(R.id.Three);
        mFour = (RadioButton) findViewById(R.id.Four);
        mFive = (RadioButton) findViewById(R.id.Five);
    }

    @Override
    public void show(String ss, String type) {
        Gson gson = new Gson();
        myTitle = gson.fromJson(ss, MyTitle.class);
        url = myTitle.getTab().get(0).getUrl();
        FragmentBuilder.getInstance().init().add(R.id.Fragment, HomeFragment.class, false).Builder();
        mOne.setText(myTitle.getTab().get(0).getTitle());
        mTwo.setText(myTitle.getTab().get(1).getTitle());
        mThree.setText(myTitle.getTab().get(2).getTitle());
        mFour.setText(myTitle.getTab().get(3).getTitle());
        mFive.setText(myTitle.getTab().get(4).getTitle());
        mRg = (RadioGroup) findViewById(R.id.Rg);
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.One:
                        url = myTitle.getTab().get(0).getUrl();
                        FragmentBuilder.getInstance().init().add(R.id.Fragment, HomeFragment.class, false).Builder();
                        break;
                    case R.id.Two:
                        App.mActivity.title.setText(myTitle.getTab().get(1).getTitle());
                        url = myTitle.getTab().get(1).getUrl();
                        FragmentBuilder.getInstance().init().add(R.id.Fragment, CultureFragment.class, false).Builder();
                        break;
                    case R.id.Three:
                        App.mActivity.title.setText(myTitle.getTab().get(2).getTitle());
                        url = myTitle.getTab().get(2).getUrl();
                        FragmentBuilder.getInstance().init().add(R.id.Fragment, ObservationFragment.class, false).Builder();
                        break;
                    case R.id.Four:
                        App.mActivity.title.setText(myTitle.getTab().get(3).getTitle());
                        url = myTitle.getTab().get(3).getUrl();
                        FragmentBuilder.getInstance().init().add(R.id.Fragment, LiveFragment.class, false).Builder();
                        break;
                    case R.id.Five:
                        App.mActivity.title.setText(myTitle.getTab().get(4).getTitle());
                        url = myTitle.getTab().get(4).getUrl();
                        FragmentBuilder.getInstance().init().add(R.id.Fragment, ChinaFragment.class, false).Builder();
                        break;
                }
            }
        });
    }

    public interface FaSong {
        void setData(String url);
    }

    public void getInter(FaSong faSong) {
        faSong.setData(url);
    }

    //退出
    @Override
    public void onBackPressed() {
        if (!isQuit) {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            isQuit = true;
            //这段代码意思是,在两秒钟之后isQuit会变成false
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        isQuit = false;
                    }
                }
            }).start();
        } else {
            System.exit(0);
        }
    }
}
