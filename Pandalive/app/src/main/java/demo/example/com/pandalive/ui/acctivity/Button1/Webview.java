package demo.example.com.pandalive.ui.acctivity.Button1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import demo.example.com.pandalive.R;

public class Webview extends AppCompatActivity implements View.OnClickListener {

    private ImageView main_imageView_Login2;
    private WebView Webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        initView();

        initshow();
    }

    /**
     * webview的页面   点击事件    然后分享
     */
    private void initshow() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Webview.loadUrl(name);

    }

    private void initView() {
        main_imageView_Login2 = (ImageView) findViewById(R.id.main_imageView_Login2);
        Webview = (WebView) findViewById(R.id.Webview);
        Webview.setOnClickListener(this);
        main_imageView_Login2.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    //分享的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_imageView_Login2:
                Log.e("点击到了","点击了这个");

                new ShareAction(Webview.this)
                        .withText("hello")
                        .withMedia(new UMImage(Webview.this,R.mipmap.hudong_sign))
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {

                            }
                        })
                        .open();

        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

    }

}