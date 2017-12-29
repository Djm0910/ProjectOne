package demo.example.com.pandalive.ui.acctivity.Button2;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import demo.example.com.pandalive.R;

//登录页面
public class Login_One extends AppCompatActivity implements View.OnClickListener, UMAuthListener {

    private Button button_login;
    private ImageView Weichat;
    private ImageView QQ;
    private ImageView Weibo;
    private ImageView Back_Login;
    private EditText edittext_login_user;
    private EditText edittext_login_pwd;

    /**
     * 登录页面
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {

        button_login = (Button) findViewById(R.id.button_login);
        Back_Login = (ImageView) findViewById(R.id.Back_Login);
        button_login.setOnClickListener(this);
        Weichat = (ImageView) findViewById(R.id.Weichat);
        Weichat.setOnClickListener(this);
        QQ = (ImageView) findViewById(R.id.QQ);
        QQ.setOnClickListener(this);
        Weibo = (ImageView) findViewById(R.id.Weibo);
        Weibo.setOnClickListener(this);
        Back_Login = (ImageView) findViewById(R.id.Back_Login);
        Back_Login.setOnClickListener(this);

        edittext_login_user = (EditText) findViewById(R.id.edittext_login_user);
        edittext_login_user.setOnClickListener(this);
        edittext_login_pwd = (EditText) findViewById(R.id.edittext_login_pwd);
        edittext_login_pwd.setOnClickListener(this);
    }

    //第三方那个登陆  QQ  微信  还有微博
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Back_Login:
                Intent intent = new Intent(Login_One.this, Login.class);
                startActivity(intent);
                break;
            case R.id.QQ:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, this);
                break;
            case R.id.Weichat:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, this);
                break;
            case R.id.Weibo:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.SINA, this);
                break;
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

    }

    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
