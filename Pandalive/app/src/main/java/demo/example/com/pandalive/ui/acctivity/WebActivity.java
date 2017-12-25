package demo.example.com.pandalive.ui.acctivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.app.App;
import demo.example.com.pandalive.base.BaseActivity;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;

/**
 * Created by 丁军明 on 2017/12/24.
 */

public class WebActivity extends BaseActivity<NetPresenter, NetModel> implements NetContract.View {
    private WebView mWebView;

    @Override
    public void show(String ss, String type) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_web);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        App.mActivity.mHuDong.setVisibility(View.GONE);
        App.mActivity.mPanda.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.personal_back_img));
        App.mActivity.mPanda.setVisibility(View.VISIBLE);
        App.mActivity.title.setVisibility(View.GONE);
        mWebView = (WebView) findViewById(R.id.WebView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(url);
        App.mActivity.mPanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
