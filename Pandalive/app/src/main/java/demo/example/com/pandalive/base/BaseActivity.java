package demo.example.com.pandalive.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.app.App;
import demo.example.com.pandalive.ui.acctivity.MainActivity;
import demo.example.com.pandalive.utils.TUtils;

/**
 * Created by 丁军明 on 2017/11/27.
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {
    private int layoutId;
    public P mPresenter;
    public M mModel;
    private FrameLayout frameLayout;
    public TextView title;
    public ImageView mLoain,mHuDong,mPanda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.setContentView(R.layout.titlebar);

        frameLayout = (FrameLayout) findViewById(R.id.frame);
        title = (TextView) findViewById(R.id.TextName);
        mHuDong = (ImageView) findViewById(R.id.hudongImage);
        mPanda = (ImageView) findViewById(R.id.ImageViewBar);
        mLoain = (ImageView) findViewById(R.id.ImageDengLu);
        App.mActivity = this;
        mPresenter = TUtils.getT(this, 0);
        mModel = TUtils.getT(this, 1);

        if (this instanceof BaseView) {
            mPresenter.setVM(mModel, this);
        }
        initView();
        initData();


    }

    protected abstract void initData();


    protected abstract void initView();




    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View view = LayoutInflater.from(BaseActivity.this).inflate(layoutResID, null);
        setContentView(view);
    }

    @Override
    public void setContentView(View view) {
        frameLayout.removeAllViews();
        frameLayout.addView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }


}

